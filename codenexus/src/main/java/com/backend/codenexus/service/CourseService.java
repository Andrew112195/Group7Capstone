package com.backend.codenexus.service;

import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.TaskQuestionBuilder;

import java.util.List;

public interface CourseService {
    
    //Course Methods
    void addNewCourseToUser(long user_id, long course_id);

    List <CourseEntity> getCourseList();

    List<UserCourseEntity> getCourse(Long user_id);

    List<UserCourseEntity> getAllClassmates(Long user_id);
    
    List<UserCourseEntity> getUsersSameCourse(UserCourseEntity userCourse);

    //Module Methods
    List <ModuleEntity> getCourseModules(Long course_id);

    //Task Methods
    void completeTask(Long task_id);

    void addTaskToModule(TaskEntity task);

    List<TaskEntity> findAllTasksByModuleId(Long courseId);

    TaskEntity getTask(Long task_id);

    List<TaskEntity> getModuleTasks(Long module_id);

    TaskQuestionBuilder buildTaskQuestion(ModuleEntity module, TaskEntity task);

    void update(Long taskId, String answer);

    //Quiz Methods
    QuizEntity getQuiz(Long quiz_id);

    void completeQuiz(Long quiz_id);

    QuizEntity getModuleQuiz(Long module_id);

    void addQuizToModule(QuizEntity quiz);

}