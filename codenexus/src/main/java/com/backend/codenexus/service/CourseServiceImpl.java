package com.backend.codenexus.service;

import java.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.*;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.*;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> getCourseListFromUser(Long course_id){
        List<Course> course = new ArrayList<Course>();
        List<CourseEntity> courseEntity = courseDao.findAllByUserId();
        BeanUtils.copyProperties(courseEntity,course);
        return course;
    }

    @Override
    public List<Course> getCourseList(){
        List <Course> courseList = new ArrayList<Course>();
        List <CourseEntity> courseEntity = courseDao.findAll();
        BeanUtils.copyProperties(courseEntity, courseList);
        return courseList;
    }

    @Override
    public List<Course> getStudentCompletedCourses(){
        List<Course> courseList = new ArrayList<Course>();
        List <CourseEntity> courseEntity = courseDao.findAllCompletedByUserId();
        BeanUtils.copyProperties(courseEntity, courseList);
        return courseList;
    }

    @Override
    public List<Course> getStudentIncompleteCourses(){
        List<Course> courseList = new ArrayList<Course>();
        List <CourseEntity> courseEntity = courseDao.findAllIncompletedByUserId();
        BeanUtils.copyProperties(courseEntity, courseList);
        return courseList;
    }
}
