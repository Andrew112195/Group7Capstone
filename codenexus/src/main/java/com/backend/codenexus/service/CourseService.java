package com.backend.codenexus.service;

import java.util.*;

import com.backend.codenexus.model.Course;
import com.backend.codenexus.model.Module;

public interface CourseService {
    
    List <Course> getCourseListFromUser(Long courseId);

    List <Course> getCourseList();

    List <Course> getStudentCompletedCourses(Long user_id);

    List <Course> getStudentIncompleteCourses(Long user_id);

    List <Module> getCourseModules(Long course_id);

}
