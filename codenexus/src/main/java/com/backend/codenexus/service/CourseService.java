package com.backend.codenexus.service;

import java.util.*;

import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.UserCourseEntity;

//import com.backend.codenexus.model.Course;
//import com.backend.codenexus.model.Module;
//import com.backend.codenexus.model.UserCourse;

public interface CourseService {
    

    List <CourseEntity> getCourseList();

    List <CourseEntity> getStudentCompletedCourses(Long user_id);

    List <CourseEntity> getStudentIncompleteCourses(Long user_id);

    //List <Module> getCourseModules(Long course_id);

    List<UserCourseEntity> getCourse(Long user_id);

    void addNewCourseToUser(long user_id, long course_id);

}