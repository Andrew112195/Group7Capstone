package com.backend.codenexus.service;

import java.util.List;

import com.backend.codenexus.entity.MessagesEntity;
import com.backend.codenexus.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MessagesService {

    UserEntity getMessages(UserEntity user);
    
    List<MessagesEntity> getSentMessages(Long user_id);

    MessagesEntity readMessage(Long message_id);

    MessagesEntity saveMessage(MessagesEntity message);

}
