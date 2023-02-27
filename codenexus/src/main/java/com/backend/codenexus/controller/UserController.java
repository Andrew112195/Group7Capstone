package com.backend.codenexus.controller;

import com.backend.codenexus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
      /*   userService.register(user); */
        return "index";
    }
    @GetMapping("register")
    public String registration(){

        return "register";
    }
    @PostMapping("register.process")
    public String registerProcess(@RequestBody User user){
        userService.register(user);
        return "index";
    }
    @PostMapping("login.process")
    public String getUserCourse(@ModelAttribute("user") User user, Model model) {    
       User checkUser = userService.login(user);
       if(checkUser != null){
        return "ide";
       }else{
        //redirect
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