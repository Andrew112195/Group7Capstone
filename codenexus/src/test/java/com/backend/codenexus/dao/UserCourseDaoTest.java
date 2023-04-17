package com.backend.codenexus.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserCourseDaoTest {

    @Autowired
    private UserCourseDao userCourseDao;
    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        // initialize test data
    }
    
    @Test
    @Transactional
    void testFindByUserId() {
        UserEntity userOne = UserEntity.builder()
            .userTypeId(1)
            .firstname("test")
            .lastname("case")
            .username("tcase")
            .password("pword")
            .build();
        UserEntity userTwo = UserEntity.builder()
            .userTypeId(1)
            .firstname("t")
            .lastname("c")
            .username("tc")
            .password("pw")
            .build();
        
        UserEntity mergedUser = entityManager.merge(userOne);
        UserEntity mergedUser2 = entityManager.merge(userTwo);

        UserCourseEntity userCourse1 = UserCourseEntity.builder()
            .user(mergedUser)
            .cohort("A")
            .progress(0)
            .build();
        UserCourseEntity userCourse2 = UserCourseEntity.builder()
            .user(mergedUser)
            .cohort("B")
            .progress(0)
            .build();
        UserCourseEntity userCourse3 = UserCourseEntity.builder()
            .user(mergedUser2)
            .cohort("C")
            .progress(0)
            .build();
        
        userCourseDao.saveAndFlush(userCourse1);
        userCourseDao.saveAndFlush(userCourse2);
        userCourseDao.saveAndFlush(userCourse3);

        List<UserCourseEntity> result = userCourseDao.findByUserId(mergedUser.getId());
        Assertions.assertTrue(result.size() == 2);
    }

    @Test
    @Transactional
    void testFindClassmates() {
        UserEntity userOne = UserEntity.builder()
            .userTypeId(1)
            .firstname("test")
            .lastname("case")
            .username("tcase")
            .password("pword")
            .build();
        UserEntity userTwo = UserEntity.builder()
            .userTypeId(1)
            .firstname("t")
            .lastname("c")
            .username("tc")
            .password("pw")
            .build();
        
        UserEntity mergedUser = entityManager.merge(userOne);
        UserEntity mergedUser2 = entityManager.merge(userTwo);

        UserCourseEntity userCourse1 = UserCourseEntity.builder()
            .user(mergedUser)
            .cohort("A")
            .progress(0)
            .build();
        UserCourseEntity userCourse2 = UserCourseEntity.builder()
            .user(mergedUser)
            .cohort("B")
            .progress(0)
            .build();
        UserCourseEntity userCourse3 = UserCourseEntity.builder()
            .user(mergedUser2)
            .cohort("A")
            .progress(0)
            .build();
        UserCourseEntity userCourse4 = UserCourseEntity.builder()
            .user(mergedUser2)
            .cohort("B")
            .progress(0)
            .build();
        
        userCourseDao.saveAndFlush(userCourse1);
        userCourseDao.saveAndFlush(userCourse2);
        userCourseDao.saveAndFlush(userCourse3);
        userCourseDao.saveAndFlush(userCourse4);

        List<UserCourseEntity> result = userCourseDao.findClassmates(mergedUser.getId());
        Assertions.assertTrue(result.size() == 2);
    }
}
