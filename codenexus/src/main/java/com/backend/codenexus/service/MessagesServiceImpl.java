package com.backend.codenexus.service;

import java.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.*;
import com.backend.codenexus.dao.*;
import com.backend.codenexus.entity.*;
import com.backend.codenexus.model.*;

@Service
public class MessagesServiceImpl implements MessagesService {
    final static Logger Log = LoggerFactory.getLogger(MessagesServiceImpl.class);

    @Autowired
    MessageDao messageDao;

    @Override
    public List<Message> getMessages(Long user_id) {
        List<MessagesEntity> messagesEntity = messageDao.findAllByUserId(user_id);
        List<Message> msgList = new ArrayList<Message>();
        for (MessagesEntity source: messagesEntity ) {
            Message target = new Message();
            BeanUtils.copyProperties(source , target);
            msgList.add(target);
         }
        return msgList;
    }

    @Override
    public List<Message> getSentMessages(Long user_id) {
        List<MessagesEntity> messagesEntity = messageDao.findAllSentByUserId(user_id);
        List<Message> msgList = new ArrayList<Message>();
        for (MessagesEntity source: messagesEntity ) {
            Message target = new Message();
            BeanUtils.copyProperties(source , target);
            msgList.add(target);
         }
        return msgList;
    }

    @Override
    public Message readMessage(Long message_id){
        MessagesEntity source = messageDao.findByMessageId(message_id);
        source.setRead(true);
        messageDao.saveAndFlush(source);    //saves read reciept
        Message target = new Message();
        BeanUtils.copyProperties(source, target);        
        return target;
    }

    @Override
    public Message saveMessage(Message message) {
        MessagesEntity messagesEntity = new MessagesEntity();
        BeanUtils.copyProperties(message, messagesEntity);

        messageDao.saveAndFlush(messagesEntity);
        return null;
    }
}
