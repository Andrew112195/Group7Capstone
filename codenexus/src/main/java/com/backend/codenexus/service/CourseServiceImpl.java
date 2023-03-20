package com.backend.codenexus.service;

import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    final static Logger Log = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    CourseDao courseDao;
    @Autowired
    UserCourseDao userCourseDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ModuleDao moduleDao;
    @Autowired
    TaskDao taskDao;
    @Autowired
    QuizDao quizDao;

    //Course methods


    @Override
    public UserCourseEntity updateCourses(UserCourseEntity userCourse){
        return userCourse = userCourseDao.updateAllCourses();
    }

    @Override
    public void addNewCourseToUser(long user_id, long course_id) {
        try {
            UserEntity foundUser = userDao.findById(user_id);
            CourseEntity foundCourse = courseDao.findById(course_id).orElseThrow();
            UserCourseEntity userCourseEntity = new UserCourseEntity();
            userCourseEntity.setUser(foundUser);
            userCourseEntity.setCourse(foundCourse);
            userCourseDao.saveAndFlush(userCourseEntity);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<CourseEntity> getCourseList(){
        List <CourseEntity> courseEntity = courseDao.findAll();
        
        return courseEntity;
    }

    @Override
    public List<CourseEntity> getStudentCompletedCourses(Long user_id){
        List <CourseEntity> courseEntity = courseDao.findAllCompletedByUserId(user_id);
        
        return courseEntity;
    }

    @Override
    public List<CourseEntity> getStudentIncompleteCourses(Long user_id){
        List <CourseEntity> courseEntity = courseDao.findAllIncompletedByUserId(user_id);
        
        return courseEntity;
    }

    @Override
    public List<UserCourseEntity> getCourse(Long user_id) {
        Log.info("UserCourseServiceImpl getCourse");
        List<UserCourseEntity> userCourses = userCourseDao.findByUserId(user_id);
        
        return userCourses;
    }

    //Module Methods

    @Override
    public List<ModuleEntity> getCourseModules(Long course_id){
        List<ModuleEntity> moduleEntity = courseDao.findAllModulesByCourseId(course_id);
        
        return moduleEntity;
    }

    //Task Methods

    @Override
    public void completeTask(Long task_id) {
        TaskEntity taskEntity = getTask(task_id);
        taskEntity.setComplete(true);
        taskDao.saveAndFlush(taskEntity);
    }

    @Override
    public void addTaskToModule(TaskEntity task) {
        TaskEntity taskEntity = new TaskEntity();
        taskDao.saveAndFlush(taskEntity);
    }

    @Override
    public List<TaskEntity> findAllTasksByModuleId(Long moduleId) {
        List<TaskEntity> taskEntityList = taskDao.findAllByModuleId(moduleId);
        
        return taskEntityList;
    }

    @Override
    public TaskEntity getTask(Long task_id) {
        TaskEntity taskEntity = moduleDao.findTaskById(task_id);
        return taskEntity;
    }

    @Override
    public List<TaskEntity> getModuleTasks(Long module_id) {
        List<TaskEntity> taskEntity = moduleDao.findTasksByModuleId(module_id);

        return taskEntity;
    }

    //Quiz Methods

    @Override
    public QuizEntity getQuiz(Long quiz_id) {
        QuizEntity quizEntity = quizDao.findByQuizId(quiz_id);
        return quizEntity;
    }

    @Override
    public void completeQuiz(Long quiz_id) {
        QuizEntity quizEntity = getQuiz(quiz_id);
        quizEntity.setComplete(true);
        quizDao.saveAndFlush(quizEntity);
    }

    @Override
    public QuizEntity getModuleQuiz(Long module_id){
        QuizEntity quizEntity = moduleDao.findQuizById(module_id);
        return quizEntity;
    }

    @Override
    public List<UserCourseEntity> getAllClassmates(Long user_id){
        List<UserCourseEntity> classMates = userCourseDao.findClassmates(user_id);
        return classMates;
    }
    @Override
    public List<UserCourseEntity> getUsersSameCourse(UserCourseEntity userCourse){
        List<UserCourseEntity> userList = userCourseDao.findUsersInSameCourse(userCourse.getCourse().getId(), userCourse.getUser().getId());
        return userList;
    }

    @Override
    public void addQuizToModule(QuizEntity quiz) {
        QuizEntity quizEntity = new QuizEntity();
        quizDao.saveAndFlush(quizEntity);
    }
}
