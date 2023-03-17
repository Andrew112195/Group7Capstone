package com.backend.codenexus.service;

import java.util.*;

import org.slf4j.*;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService {
    final static Logger Log = LoggerFactory.getLogger(MessagesServiceImpl.class);

    @Autowired
    MessageDao messageDao;
    UserDao userDao;
    @Override
    public UserEntity getMessages(UserEntity user) {
        //List<MessagesEntity> messagesEntity = messageDao.findAllByUserId(user_id);
        //return messagesEntity;
        return messageDao.findAllByUserId(user.getId());
    }

    @Override
    public List<MessagesEntity> getSentMessages(Long user_id) {
        List<MessagesEntity> messagesEntity = messageDao.findAllSentByUserId(user_id);
        
        return messagesEntity;
    }

    @Override
    public MessagesEntity readMessage(Long message_id){
        MessagesEntity source = messageDao.findByMessageId(message_id);
        source.setRead(true);
        messageDao.saveAndFlush(source);
              
        return source;
    }

    @Override
    public MessagesEntity saveMessage(MessagesEntity message) {
        messageDao.saveAndFlush(message);
        return null;
    }
}
