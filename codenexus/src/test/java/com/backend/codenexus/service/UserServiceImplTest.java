package com.backend.codenexus.service;

import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.UserEntity;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserServiceImplTest {

    @Autowired
    UserDao testDao;

    UserEntity user = null;
    @Autowired
    public void setTestUser(){
        user = new UserEntity();
        user.setId(1000L);
        user.setUserTypeId(1);
        user.setEmail("Johndoe@test.com");
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setUsername("Johndoe");
        user.setPassword("password1");
        //MockitoAnnotations.initMocks(this);
        testDao.save(user);
    }


    @Test
    public void testRegisterDuplicateUsername() {
        //setTestUser();
        //when(!mockDao.existsByUsername("Johndoe")).thenReturn(true);
        assertTrue(testDao.existsByUsername("Johndoe"), "this user doesnt exist");
    }

    @Test
    void updateUser() {
    }

    @Test
    void login() {
    }

    @Test
    void getAllStudents() {
    }
}