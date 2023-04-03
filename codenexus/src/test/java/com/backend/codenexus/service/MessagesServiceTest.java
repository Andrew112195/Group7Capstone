package com.backend.codenexus.service;

import com.backend.codenexus.dao.MessageDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.MessagesEntity;
import com.backend.codenexus.entity.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2) // mock DB for DAO tests
public class MessagesServiceTest {

    @BeforeAll
    public void setUpUser1() {
        // Set up test user for unit testing
        UserEntity user = new UserEntity();
        user.setId(1000L);
        user.setUserTypeId(1);
        user.setEmail("johndoe@test.com");
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setUsername("johndoe");
        user.setPassword("password1");
        userDao.save(user);
    }

    @BeforeAll
    public void setUpUser2() {
        // Set up test user for unit testing
        UserEntity user = new UserEntity();
        user.setId(1001L);
        user.setUserTypeId(1);
        user.setEmail("janedoe@test.com");
        user.setFirstname("Jane");
        user.setLastname("Doe");
        user.setUsername("janedoe");
        user.setPassword("password1");
        userDao.save(user);
    }
    @Autowired
    private MessagesService messagesService;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    //dao
    @Test
    public void testFindByMessageId(){
        // create a test message entity
        MessagesEntity message = new MessagesEntity();
        message.setHeader("Test message");
        message.setMessage("This is a test message.");
        message.setSender(userDao.findById(1000L));
        message.setRecipient(userDao.findById(10001L));

        //Save in DB
        messageDao.saveAndFlush(message);

        //Get in DB
        MessagesEntity result = messageDao.findByMessageId(message.getId());

        //True if fetched
        assertNotNull(result);
    }

    //service
    @Test
    public void testSaveMessage() {
        // create a test message entity
        MessagesEntity message = new MessagesEntity();
        message.setHeader("Test message");
        message.setMessage("This is a test message.");
        message.setSender(userDao.findById(1000L));
        message.setRecipient(userDao.findById(10001L));

        // save the message
        messagesService.saveMessage(message);

        // check that the message was saved successfully
        assertNotNull(message.getId());
    }

    @Test
    public void testReadMessage() {
        // create a test message entity
        MessagesEntity message = new MessagesEntity();
        message.setHeader("Test message");
        message.setMessage("This is a test message.");
        message.setSender(userDao.findById(1000L));
        message.setRecipient(userDao.findById(10001L));

        // save the message
        messageDao.saveAndFlush(message);

        // read the message
        MessagesEntity result = messagesService.readMessage(message.getId());

        // check that the message was marked as read
        assertTrue(result.isRead());
    }


}