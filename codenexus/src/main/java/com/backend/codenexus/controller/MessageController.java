package com.backend.codenexus.controller;

import com.backend.codenexus.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.MessagesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class MessageController {

    /*
     * @TODO
     * Gonna try to add a user and a course to see if that will work with adding
     * userCourse to the database.
     */
    @Autowired
    MessagesService messagesService;

    @GetMapping("/sent")
    public List<Message> getSentMessages(@RequestBody Long user_id) {
        return messagesService.getSentMessages(user_id);
    }

    @GetMapping("/inbox/{user_id}")
    public List<Message> getMessages(@PathVariable Long user_id) {
        return messagesService.getMessages(user_id);
    }

    @PostMapping("/save")
    public void saveMessages(Message message) {
        messagesService.saveMessage(message);
    }

}