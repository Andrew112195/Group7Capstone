package com.backend.codenexus.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.codenexus.entity.*;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.model.Course;
import com.backend.codenexus.model.Module;

@Service
public class CourseServiceImpl implements CourseService {
    final static Logger Log = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> getCourseList(){
        List <Course> courseList = new ArrayList<Course>();
        List <CourseEntity> courseEntity = courseDao.findAll();
        for (CourseEntity source: courseEntity ) {
            Course target = new Course();
            BeanUtils.copyProperties(source , target);
            courseList.add(target);
        }
        return courseList;
    }

    @Override
    public List<Course> getStudentCompletedCourses(Long user_id){
        List<Course> courseList = new ArrayList<Course>();
        List <CourseEntity> courseEntity = courseDao.findAllCompletedByUserId(user_id);
        for (CourseEntity source: courseEntity ) {
            Course target = new Course();
            BeanUtils.copyProperties(source , target);
            courseList.add(target);
        }
        return courseList;
    }

    @Override
    public List<Course> getStudentIncompleteCourses(Long user_id){
        List<Course> courseList = new ArrayList<Course>();
        List <CourseEntity> courseEntity = courseDao.findAllIncompletedByUserId(user_id);
        for (CourseEntity source: courseEntity ) {
            Course target = new Course();
            BeanUtils.copyProperties(source , target);
            courseList.add(target);
        }
        return courseList;
    }
    
//    @Override
//    public List<Module> getCourseModules(Long course_id){
//        List<Module> courseModules = new ArrayList<Module>();
//        List<ModuleEntity> moduleEntity = courseDao.findAllModulesByCourseId(course_id);
//        for (ModuleEntity source: moduleEntity ) {
//            Module target = new Module();
//            BeanUtils.copyProperties(source , target);
//            courseModules.add(target);
//        }
//        return courseModules;
//    }


}
