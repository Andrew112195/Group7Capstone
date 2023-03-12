package com.backend.codenexus.service;

import java.util.List;

import com.backend.codenexus.entity.MessagesEntity;

public interface MessagesService {

    List<MessagesEntity> getMessages(Long user_id);
    
    List<MessagesEntity> getSentMessages(Long user_id);

    MessagesEntity readMessage(Long message_id);

    MessagesEntity saveMessage(MessagesEntity message);

}
