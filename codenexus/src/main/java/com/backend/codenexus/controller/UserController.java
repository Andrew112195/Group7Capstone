/*package com.backend.codenexus.controller;

import com.backend.codenexus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {

    
    @Autowired
    UserService userService;

    @GetMapping("index")
    public String index() {
        return "index";
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
    @GetMapping("login")
    public String loginProcess(){

        return "login";
    }
    @GetMapping("ide")
    public String ideLoader(){

        return "onlineIDE";
    }
}*/