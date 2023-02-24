package com.backend.codenexus.controller;

import com.backend.codenexus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.UserService;


@Controller
@RequestMapping("")
public class UserController {

    /*
     * @TODO
     * Gonna try to add a user and a course to see if that will work with adding
     * userCourse to the database.
     */
    @Autowired
    UserService userService;

    @GetMapping("index")
    public String register(ModelMap model) {
        //userService.register(user);
        return "index";
    }

    @GetMapping("/login")
    public String getUserCourse(@ModelAttribute("user") User user, Model model) {

        model.addAttribute("user", userService.login(user));

       return "login.jsp";
        //return userService.login(user);
    }

}