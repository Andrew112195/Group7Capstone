package com.backend.codenexus.service;

import java.util.*;

import com.backend.codenexus.model.*;

public interface CourseService {
    
    List <Course> getCourseListFromUser(Long course_id);

    List <Course> getCourseList();

    List <Course> getStudentCompletedCourses();

    List <Course> getStudentIncompleteCourses();

}
