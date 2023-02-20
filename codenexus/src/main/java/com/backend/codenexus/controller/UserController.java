package com.backend.codenexus.controller;

import com.backend.codenexus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    /*
     * @TODO
     * Gonna try to add a user and a course to see if that will work with adding
     * userCourse to the database.
     */
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @GetMapping("/login")
    public String getUserCourse(@ModelAttribute("user") User user, Model model) {

        model.addAttribute("user", userService.login(user));

        return "login.jsp";
        // return userService.login(user);
    }

}