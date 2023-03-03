package com.backend.codenexus.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.backend.codenexus.model.*;
import com.backend.codenexus.model.Module;
import com.backend.codenexus.service.*;



@Controller
@RequestMapping("/")
public class HomeController {

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

        return "pricing1";
    }

    @GetMapping("contact")
    public String getContact(){

        return "contact";
    }
    
    @GetMapping("login")
    public String loginProcess(){

        return "login";
    }

    @PostMapping("login-process")
    public String login(ModelMap modelMap, User user) {
       user = userService.login(user);
       if(user != null) {
           modelMap.put("welcomeMessage", "Welcome " + user.getFirstname());
           if (user.getUserTypeId() == 3) {
               return "adminDashboard";
           } else if (user.getUserTypeId() == 2) {
               return "instructorDashboard";
           } else if (user.getUserTypeId() == 1) {
               return "studentDashboard";
           }
       }
       else{
        //redirect
           modelMap.put("invalidLogin", "Incorrect user name or password, please try again");
           return "login";
       }
        return null;
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
        else{
            modelMap.put("registrationError", "User name exists already, please try again");
            return "register";
        }
    }

    @GetMapping("ide")
    public String ideLoader(){

        return "onlineIDE";
    }

    @GetMapping("student-courses")
    public String displayCourses(ModelMap modelMap, User user){
        List<Course> currentList = courseService.getCourseListFromUser(user.getId());
        for (Course current: currentList){
            modelMap.addAttribute(current.getTitle(), current);
            List<Module> currentModules = courseService.getCourseModules(current.getId());
            for (Module currentMod: currentModules){
                modelMap.addAttribute(currentMod.getName(), currentMod);
            }
        }
        return "studentDashboard";
    }

}