package com.backend.codenexus.controller;
import com.backend.codenexus.model.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.UserCourseService;

@CrossOrigin
@RestController
@RequestMapping("course")
public class UserCourseController {

    /*
       @TODO
    *    Gonna try to add a user and a course to see if that will work with adding userCourse to the database.
    * */
    @Autowired
    UserCourseService courseService;

    @PostMapping("addcourse")
    public void addCourse(@RequestBody UserCourse userCourse) {
        courseService.addNewCourseToUser(userCourse);
    }

    @GetMapping("get-course/{id}")
    public UserCourse getUserCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

}
