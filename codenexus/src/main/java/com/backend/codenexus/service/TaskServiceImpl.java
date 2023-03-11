package com.backend.codenexus.service;

import com.backend.codenexus.dao.TaskDao;
import com.backend.codenexus.entity.TaskEntity;
import com.backend.codenexus.model.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    TaskDao taskDao;


    @Override
    public List<Task> findAllTasksByCourseId(Long courseId) {
        List<TaskEntity> taskEntityList = taskDao.findAllByCourseId(courseId);
        List<Task> taskList = taskEntityList.stream().map(TaskEntity ->{
            Task task = new Task();
            BeanUtils.copyProperties(TaskEntity, task);
            return task;

        }).toList();
          return taskList;
    }

    @Override
    public void updateTaskToComplete(Task task) {

    }
}
