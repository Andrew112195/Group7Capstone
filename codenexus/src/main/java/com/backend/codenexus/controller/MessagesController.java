package com.backend.codenexus.controller;

import com.backend.codenexus.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class MessagesController {

    /*
     * @TODO
     * Gonna try to add a user and a course to see if that will work with adding
     * userCourse to the database.
     */
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody Long user_id) {
        userService.getSentMessages(user_id);
    }

    @PostMapping("/login")
    public User getUserCourse(@RequestBody User user) {
        return userService.login(user);
    }

}