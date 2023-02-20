package com.backend.codenexus.service;

import java.util.List;
import java.util.ArrayList;

import com.backend.codenexus.model.*;

public interface MessagesService {

    List<Message> getMessages(Long user_id);
    
    List<Message> getSentMessages(Long user_id);

    Message saveMessage(Message message);

}
