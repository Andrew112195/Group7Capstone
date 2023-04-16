package com.backend.codenexus.service;

import com.backend.codenexus.dao.MessageDao;
import com.backend.codenexus.entity.MessagesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService {
    final static Logger Log = LoggerFactory.getLogger(MessagesServiceImpl.class);

    @Autowired
    private MessageDao messageDao;

    @Override
    public MessagesEntity readMessage(Long message_id) {
        try {
            MessagesEntity source = messageDao.findByMessageId(message_id);
            source.setRead(true);
            messageDao.saveAndFlush(source);
            return source;
        } catch (Exception e) {
            Log.error("Error occurred while reading message with ID {}", message_id, e);
            throw new RuntimeException("Error occurred while reading message with ID " + message_id, e);
        }
    }

    @Override
    public MessagesEntity saveMessage(MessagesEntity message) {
        try {
            return messageDao.saveAndFlush(message);
        } catch (Exception e) {
            Log.error("Error occurred while saving message: {}", message, e);
            throw new RuntimeException("Error occurred while saving message: " + message, e);
        }
    }
}