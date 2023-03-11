package com.backend.codenexus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.backend.codenexus.model.*;
import com.backend.codenexus.service.CourseService;
import com.backend.codenexus.service.UserCourseService;
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
    @Autowired
    UserCourseService userCourseService;

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

    @PostMapping("addcourse/{userId}/{courseId}")
    public String addUserCourse(@PathVariable("userId")long userId,@PathVariable("courseId") long courseId) {

        userCourseService.addNewCourseToUser(userId,courseId);

        return "redirect:/students";
    }

    @GetMapping("students")
    public String getStudents(ModelMap modelMap){

        modelMap.put("students", userService.getAllStudents());
        modelMap.addAttribute("courses", courseService.getCourseList());

        return "instructorDashboard";
    }

    @GetMapping(value="get-userCourses/{id}",produces = MediaType.ALL_VALUE)
    public String getUserCourse(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("userCourses",userCourseService.getCourse(id));

        return "studentDashboard";
    }

    @PostMapping("login-process")
    public String login(ModelMap modelMap, User user) {
       user = userService.login(user);

        try {
            if(user != null) {
                long userId = user.getId();
                modelMap.put("welcomeMessage", "Welcome " + user.getFirstname());
                 modelMap.addAttribute("userId", userId);
                if (user.getUserTypeId() == 3) {

                    return "adminDashboard";
                } else if (user.getUserTypeId() == 2) {

                    return "redirect:/students";
                } else if (user.getUserTypeId() == 1) {
                        userId = user.getId();
                    return "redirect:/get-userCourses/"+userId;
                }
            }
            
             //redirect
            modelMap.put("invalidLogin", "Incorrect user name or password, please try again");
            return "login";
            
        } catch (Exception e) {
            e.printStackTrace();
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
        
        modelMap.put("registrationError", "User name exists already, please try again");
        return "register";
    }

    @GetMapping("ide")
    public String ideLoader(){

        return "onlineIDE";
    }
}