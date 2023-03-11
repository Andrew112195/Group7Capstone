package com.backend.codenexus.controller;
import com.backend.codenexus.model.User;
import com.backend.codenexus.model.UserCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.UserCourseService;


import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("user")
public class UserCourseController {
    private final Logger logger = LoggerFactory.getLogger(UserCourseController.class);

    /*
       @TODO
    *    Gonna try to add a user and a course to see if that will work with adding userCourse to the database.
    * */
    @Autowired
    UserCourseService courseService;

    @PostMapping("addcourse/{userId}/{courseId}")
    public void addUserCourse(@PathVariable("userId")long userId,@PathVariable("courseId") long courseId) {
        logger.info(" user courses controller to add a course to a user");

        courseService.addNewCourseToUser(userId,courseId);
    }



}
