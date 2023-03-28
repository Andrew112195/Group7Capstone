package com.backend.codenexus.service;

import com.backend.codenexus.dao.MessageDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.MessagesEntity;
import com.backend.codenexus.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
