package com.backend.codenexus.controller;

import com.backend.codenexus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {

    /*
     * @TODO
     * Gonna try to add a user and a course to see if that will work with adding
     * userCourse to the database.
     */
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
       User checkUser = userService.login(user);
       if(checkUser != null){
           modelMap.put("welcomeMessage", "Welcome " + checkUser.getFirstname());
           return "studentDashboard";
       }
       else{
        //redirect
           modelMap.put("invalidLogin", "Incorrect user name or password, please try again");
           return "login";
       }

    }
    @GetMapping("login")
    public String loginProcess(){

        return "login";
    }
    @GetMapping("ide")
    public String ideLoader(){

        return "onlineIDE";
    }
}