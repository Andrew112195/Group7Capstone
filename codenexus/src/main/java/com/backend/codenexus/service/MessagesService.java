package com.backend.codenexus.service;

import com.backend.codenexus.entity.MessagesEntity;
import com.backend.codenexus.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MessagesService {

    MessagesEntity readMessage(Long message_id);

    MessagesEntity saveMessage(MessagesEntity message);

}
