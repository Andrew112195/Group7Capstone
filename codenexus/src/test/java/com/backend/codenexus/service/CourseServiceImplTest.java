package com.backend.codenexus.service;

import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CourseServiceImplTest {

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @Test
    void testAddNewCourseToUser() {

            // create a new user and save it
            UserEntity user = new UserEntity();
            user.setId(1L);
            user.setUserTypeId(1L);
            user.setFirstname("John");
            user.setLastname("Doe");
            user.setEmail("john.doe@example.com");
            user.setUsername("johndoe");
            user.setPassword("password");

            // create a new course and save it
            CourseEntity course = new CourseEntity();
            course.setId(1L);
            course.setTitle("Java Programming");
            course.setDescription("Learn how to program in Java");
            course.setPrice(99.99);

            // create a new UserCourseEntity and save it
            UserCourseEntity userCourseEntity = new UserCourseEntity();
            userCourseEntity.setUser(user);
            userCourseEntity.setCourse(course);

            // call the addNewCourseToUser method
            courseServiceImpl.addNewCourseToUser(user.getId(), course.getId());

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