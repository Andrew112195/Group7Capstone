package com.backend.codenexus.service;

import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.TaskQuestionBuilder;


import java.util.List;


public interface CourseService {
    
    //Course Methods
    void addNewCourseToUser(long user_id, long course_id);

    List <CourseEntity> getCourseList();

    CourseEntity getSingleCourse(Long course_id);

    List<UserCourseEntity> getCourse(Long user_id);

    List<UserCourseEntity> getAllClassmates(Long user_id);

    //Module Methods
    List <ModuleEntity> getCourseModules(Long course_id);

    List<ModuleEntity> getAllModules();

    //Task Methods
    void completeTask(String gettingTaskByQuestion,String answer);

    List<TaskEntity> findAllTasksByModuleId(Long courseId);

    TaskEntity getTask(Long task_id);

    TaskEntity getTaskByQuestion(String question);

    void saveTask(TaskEntity task);

    TaskQuestionBuilder buildTaskQuestion(ModuleEntity module, TaskEntity task);

    //Quiz Methods
    QuizEntity getQuiz(Long quiz_id);

    void completeQuiz(Long quiz_id);

    QuizEntity getModuleQuiz(Long module_id);

    void addQuizToModule(QuizEntity quiz);

}