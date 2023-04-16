package com.backend.codenexus.service;

import com.backend.codenexus.entity.MessagesEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MessagesService {

    MessagesEntity readMessage(Long message_id);

    MessagesEntity saveMessage(MessagesEntity message);

}