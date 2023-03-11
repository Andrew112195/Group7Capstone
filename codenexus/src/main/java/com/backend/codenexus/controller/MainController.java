package com.backend.codenexus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.backend.codenexus.model.*;
import com.backend.codenexus.service.CourseService;
import com.backend.codenexus.service.UserService;



@Controller
@RequestMapping("/")
@SessionAttributes
@CrossOrigin
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("aboutus")
    public String getAboutus(){

        return "aboutUs";
    }

    @GetMapping("pricing")
    public String getPricing(){

        return "pricing";
    }

    @GetMapping("contact")
    public String getContact(){

        return "contact";
    }
    
    @GetMapping("login")
    public String loginProcess(){

        return "login";
    }

    @GetMapping(value="get-courses", produces=MediaType.ALL_VALUE)
    public String getCourses(ModelMap modelMap) {
        List<Course> courses = courseService.getCourseList();

        modelMap.addAttribute("courses", courses);
        return "studentDashboard"; // return the name of the JSP page where the courses will be displayed
    }

    @GetMapping("students")
    public String getStudents(ModelMap modelMap){

        modelMap.put("students", userService.getAllStudents());

        return "instructorDashboard";
    }

    @PostMapping("login-process")
    public String login(ModelMap modelMap, User user) {
       user = userService.login(user);
       if(user != null) {
           modelMap.put("welcomeMessage", "Welcome " + user.getFirstname());
           if (user.getUserTypeId() == 3) {
                return "adminDashboard";
           } else if (user.getUserTypeId() == 2) {
                return "redirect:students";
           } else if (user.getUserTypeId() == 1) {
                return "redirect:get-courses";
           }
       }
        //redirect
        modelMap.put("invalidLogin", "Incorrect user name or password, please try again");
        return "login";
    }


    @GetMapping("register")
    public String registration(){

        return "register";
    }

    @PostMapping("register-process")
    public String registerProcess(ModelMap modelMap, User user){
        if(userService.register(user)) {
            modelMap.put("successfulRegistration", "Thank you for your registration!! " + user.getFirstname());
            return "login";
        }
        
        modelMap.put("registrationError", "User name exists already, please try again");
        return "register";
    }

    @GetMapping("ide")
    public String ideLoader(){

        return "onlineIDE";
    }
}