package com.backend.codenexus.service;

import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.TaskQuestionBuilder;

import java.util.List;

//import com.backend.codenexus.model.Course;
//import com.backend.codenexus.model.Module;
//import com.backend.codenexus.model.UserCourse;

public interface CourseService {
    
    List <CourseEntity> getCourseList();

    //List <CourseEntity> getStudentCompletedCourses(Long user_id);

    //List <CourseEntity> getStudentIncompleteCourses(Long user_id);

    List <ModuleEntity> getCourseModules(Long course_id);

    List<UserCourseEntity> getCourse(Long user_id);

    public List<UserCourseEntity> getAllClassmates(Long user_id);
    void addNewCourseToUser(long user_id, long course_id);

    TaskEntity getTask(Long task_id);

    QuizEntity getQuiz(Long quiz_id);

    void completeTask(Long task_id);

    void completeQuiz(Long quiz_id);

    List<TaskEntity> getModuleTasks(Long module_id);

    List<UserCourseEntity> getUsersSameCourse(UserCourseEntity userCourse);

    QuizEntity getModuleQuiz(Long module_id);

    void addTaskToModule(TaskEntity task);

    void addQuizToModule(QuizEntity quiz);

    List<TaskEntity> findAllTasksByModuleId(Long courseId);


    TaskQuestionBuilder buildTaskQuestion(ModuleEntity module, TaskEntity task);
}