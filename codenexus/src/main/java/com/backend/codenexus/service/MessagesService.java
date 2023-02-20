package com.backend.codenexus.service;

import java.util.List;
import java.util.ArrayList;

import com.backend.codenexus.entity.UserEntity;
import com.backend.codenexus.model.*;

public interface MessagesService {

    List<Message> getMessages(Long user_id);
    
    List<Message> getSentMessages(Long user_id);

    Message readMessage(Long message_id);

    Message saveMessage(Message message);

}
