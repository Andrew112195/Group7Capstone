package com.backend.codenexus.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.codenexus.entity.*;
import com.backend.codenexus.dao.*;

@Service
public class CourseServiceImpl implements CourseService {
    final static Logger Log = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    CourseDao courseDao;
    @Autowired
    UserCourseDao userCourseDao;
    @Autowired
    UserDao userDao;

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
    
    /*@Override
    public List<Module> getCourseModules(Long course_id){
        List<Module> courseModules = new ArrayList<Module>();
        List<ModuleEntity> moduleEntity = courseDao.findAllModulesByCourseId(course_id);
        for (ModuleEntity source: moduleEntity ) {
            Module target = new Module();
            BeanUtils.copyProperties(source , target);
            courseModules.add(target);
        }
        return courseModules;
    }*/

    @Override
    public List<UserCourseEntity> getCourse(Long user_id) {
        Log.info("UserCourseServiceImpl getCourse");
        List<UserCourseEntity> userCourses = userCourseDao.findByUserId(user_id);
        
        return userCourses;
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

}
