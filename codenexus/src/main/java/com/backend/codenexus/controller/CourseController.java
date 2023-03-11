package com.backend.codenexus.controller;

import com.backend.codenexus.model.Course;
import com.backend.codenexus.model.UserCourse;
import com.backend.codenexus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("course")
@SessionAttributes
@CrossOrigin
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("course-list")
    public String getCourses() {

        return "courseList";
    }

    @GetMapping(value = "get-courses",produces=MediaType.ALL_VALUE)
    public String getCourses(ModelMap modelMap) {
        List<Course> courses = courseService.getCourseList();

        modelMap.addAttribute("courses", courses);
        return "studentDashboard"; // return the name of the JSP page where the courses will be displayed
    }


    
}