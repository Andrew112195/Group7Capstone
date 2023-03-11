package com.backend.codenexus.service;

import com.backend.codenexus.model.UserCourse;

import java.util.List;

public interface UserCourseService {

    List<UserCourse> getCourse(Long user_id);

    void addNewCourseToUser(long user_id, long course_id);


}
