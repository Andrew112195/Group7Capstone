package com.backend.codenexus.controller;

import com.backend.codenexus.entity.UserEntity;
import com.backend.codenexus.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.codenexus.service.MessagesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("inbox")
public class MessageController {

    /*
     * @TODO
     * Gonna try to add a user and a course to see if that will work with adding
     * userCourse to the database.
     */
    @Autowired
    MessagesService messagesService;

    @GetMapping("sent/{user_id}")
    public List<Message> getSentMessages(@PathVariable Long user_id) {
        List<Message> messagesSent = messagesService.getSentMessages(user_id);
        return messagesSent;
    }

    @GetMapping("inbox/{user_id}")
    public List<Message> getMessages(@PathVariable Long user_id) {
        return messagesService.getMessages(user_id);
    }

    @GetMapping("inbox/read_message/{message_id}")
    public Message readMessage(@PathVariable Long message_id){
        return messagesService.readMessage(message_id);
    }
    @PostMapping("save")
    public void saveMessages(@RequestBody Message message) {
        messagesService.saveMessage(message);
    }

}