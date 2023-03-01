package com.backend.codenexus.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.*;

@Service
public class ModuleServiceImpl implements ModuleService {
    final static Logger Log = LoggerFactory.getLogger(ModuleServiceImpl.class);

    @Autowired
    ModuleDao moduleDao;
    TaskDao taskDao;
    QuizDao quizDao;


    @Override
    public Task getTask(Long task_id) {
        Task task = new Task();
        TaskEntity taskEntity = moduleDao.findTaskById(task_id);
        BeanUtils.copyProperties(taskEntity,task);
        return task;
    }

    @Override
    public Quiz getQuiz(Long quiz_id) {
        Quiz quiz = new Quiz();
        QuizEntity quizEntity = quizDao.findByQuizId(quiz_id);
        BeanUtils.copyProperties(quizEntity,quiz);
        return quiz;
    }
    @Override
    public void completeTask(Long task_id) {
        Task task = getTask(task_id);
        task.setComplete(true);
        TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(task,taskEntity);
        taskDao.saveAndFlush(taskEntity);
    }

    @Override
    public void completeQuiz(Long quiz_id) {
        Quiz quiz = getQuiz(quiz_id);
        quiz.setComplete(true);
        QuizEntity quizEntity = new QuizEntity();
        BeanUtils.copyProperties(quiz,quizEntity);
        quizDao.saveAndFlush(quizEntity);
    }

    @Override
    public List<Task> getModuleTasks(Long module_id) {
        List<TaskEntity> taskEntity = moduleDao.findTasksByModuleId(module_id);
        List<Task> taskList = new ArrayList();
        for (TaskEntity source: taskEntity ) {
            Task target = new Task();
            BeanUtils.copyProperties(source , target);
            taskList.add(target);
         }
        return taskList;
    }
    @Override
    public Quiz getModuleQuiz(Long module_id){
        QuizEntity quizEntity = moduleDao.findQuizById(module_id);
        Quiz quiz = new Quiz();
        BeanUtils.copyProperties(quizEntity,quiz);
        return quiz;
    }
    @Override
    public void addTaskToModule(Task task) {
        TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(task,taskEntity);
        taskDao.saveAndFlush(taskEntity);
    }

    @Override
    public void addQuizToModule(Quiz quiz) {
        QuizEntity quizEntity = new QuizEntity();
        BeanUtils.copyProperties(quiz,quizEntity);
        quizDao.saveAndFlush(quizEntity);
    }


}
