package com.backend.codenexus.service;

import com.backend.codenexus.dao.CourseDao;
import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseServiceImplTest {

    @MockBean
    private CourseDao courseDao;
    @MockBean
    private UserDao userDao;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private UserCourseDao userCourseDao;
    @Test
    void addNewCourseToUser() {

            // create a new user and save it
            UserEntity user = new UserEntity();
            user.setId(1L);
            user.setUserTypeId(1L);
            user.setFirstname("John");
            user.setLastname("Doe");
            user.setEmail("john.doe@example.com");
            user.setUsername("johndoe");
            user.setPassword("password");
            Mockito.when(userDao.findById(user.getId())).thenReturn(Optional.of(user));

            // create a new course and save it
            CourseEntity course = new CourseEntity();
            course.setId(1L);
            course.setTitle("Java Programming");
            course.setDescription("Learn how to program in Java");
            course.setPrice(99.99);
            Mockito.when(courseDao.findById(course.getId())).thenReturn(Optional.of(course));

            // create a new UserCourseEntity and save it
            UserCourseEntity userCourseEntity = new UserCourseEntity();
            userCourseEntity.setUser(user);
            userCourseEntity.setCourse(course);
            Mockito.when(userCourseDao.saveAndFlush(userCourseEntity)).thenReturn(userCourseEntity);

            // call the addNewCourseToUser method
            courseService.addNewCourseToUser(user.getId(), course.getId());

            // retrieve the UserCourseEntity from the database
            List<UserCourseEntity> userCourses = new ArrayList<>();
            userCourses.add(userCourseEntity);

            // assert that the UserCourseEntity was created and has the correct properties
            assertEquals(1, userCourses.size());
            UserCourseEntity userCourse = userCourses.get(0);
            assertNotNull(userCourse);
            assertEquals(user, userCourse.getUser());
            assertEquals(course, userCourse.getCourse());

    }

    @Test
    void getCourse() {
    }
}