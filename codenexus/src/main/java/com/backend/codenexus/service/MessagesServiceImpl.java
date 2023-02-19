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
    public List<Messages> getMessages(Long userId) {
        List<Messages> msgList = new ArrayList<Messages>();
        List<MessagesEntity> messagesEntity = messageDao.findAllByUserId(userId);
        BeanUtils.copyProperties(messagesEntity, msgList);
        return msgList;
    }

    @Override
    public void saveMessage(Messages message) {

        MessagesEntity messagesEntity = new MessagesEntity();

        BeanUtils.copyProperties(message, messagesEntity);

        messageDao.saveAndFlush(messagesEntity);
    }
}
