package com.backend.codenexus.service;

import com.backend.codenexus.model.UserCourse;

public interface UserCourseService {

    UserCourse getCourse(Long user_id);

    void addNewCourseToUser(UserCourse course);


}
