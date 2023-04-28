package com.backend.codenexus.service;

import com.backend.codenexus.dao.CourseDao;
import com.backend.codenexus.dao.ModuleDao;
import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.ModuleEntity;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CourseServiceImplTest {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private CourseServiceImpl courseServiceImpl;
    @Autowired
    private UserCourseDao userCourseDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ModuleDao moduleDao;

    @Test
    public void testAddNewCourseToUser() {

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
    public void testGetCourseList() {
        CourseEntity course1 = new CourseEntity();
        CourseEntity course2 = new CourseEntity();
        course1.setTitle("java");
        course2.setTitle("python");
        courseDao.saveAndFlush(course1);
        courseDao.saveAndFlush(course2);

        List<CourseEntity> courseList = courseServiceImpl.getCourseList();

        assertEquals(2, courseList.size());
        assertTrue(courseList.stream().anyMatch(c -> c.getTitle().equals("java")));
        assertTrue(courseList.stream().anyMatch(c -> c.getTitle().equals("python")));
    }

    @Test
    public void testGetSingleCourse() {
        CourseEntity course = new CourseEntity();
        course.setTitle("Test Course");
        courseDao.saveAndFlush(course);

        CourseEntity fetchedCourse = courseServiceImpl.getSingleCourse(course.getId());

        assertNotNull(fetchedCourse);
        assertEquals(course.getTitle(), fetchedCourse.getTitle());
    }

    @Test
    @Transactional
    public void testGetCourse() {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();
        UserEntity mergedUser = entityManager.merge(user1);
        UserEntity mergedUser2 = entityManager.merge(user2);

        UserCourseEntity userCourse1 = new UserCourseEntity();
        userCourse1.setUser(mergedUser);
        userCourseDao.saveAndFlush(userCourse1);

        UserCourseEntity userCourse2 = new UserCourseEntity();
        userCourse2.setUser(mergedUser);
        userCourseDao.saveAndFlush(userCourse2);

        UserCourseEntity userCourse3 = new UserCourseEntity();
        userCourse3.setUser(mergedUser2);
        userCourseDao.saveAndFlush(userCourse3);

        List<UserCourseEntity> userCourses = courseServiceImpl.getCourse(1L);

        assertEquals(2, userCourses.size());
        assertTrue(userCourses.stream().anyMatch(uc -> uc.getId().equals(userCourse1.getId())));
        assertTrue(userCourses.stream().anyMatch(uc -> uc.getId().equals(userCourse2.getId())));
    }

    @Test
    @Transactional
    public void testGetAllClassmates() {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();
        UserEntity mergedUser = entityManager.merge(user1);
        UserEntity mergedUser2 = entityManager.merge(user2);

        UserCourseEntity userCourse1 = new UserCourseEntity();
        userCourse1.setUser(mergedUser);
        userCourseDao.saveAndFlush(userCourse1);

        UserCourseEntity userCourse2 = new UserCourseEntity();
        userCourse2.setUser(mergedUser2);
        userCourseDao.saveAndFlush(userCourse2);

        UserCourseEntity userCourse3 = new UserCourseEntity();
        userCourse3.setUser(mergedUser2);
        userCourseDao.saveAndFlush(userCourse3);

        List<UserCourseEntity> classMates = courseServiceImpl.getAllClassmates(1L);

        assertEquals(2, classMates.size());
        assertTrue(classMates.stream().anyMatch(uc -> uc.getId().equals(userCourse2.getId())));
        assertTrue(classMates.stream().anyMatch(uc -> uc.getId().equals(userCourse3.getId())));
    }

    @Test
    public void testGetCourseModules() {
        CourseEntity course = new CourseEntity();
        course.setTitle("Test Course");
        course.setDescription("Test Description");
        course = courseDao.saveAndFlush(course);

        ModuleEntity module1 = new ModuleEntity();
        module1.setName("Module 1");
        module1.setDescription("Test Module 1");
        module1.setCourseId(course);
        module1 = moduleDao.saveAndFlush(module1);

        ModuleEntity module2 = new ModuleEntity();
        module2.setName("Module 2");
        module2.setDescription("Test Module 2");
        module2.setCourseId(course);
        module2 = moduleDao.saveAndFlush(module2);

        List<ModuleEntity> moduleList = courseServiceImpl.getCourseModules(course.getId());

        assertEquals(2, moduleList.size());
        assertTrue(moduleList.contains(module1));
        assertTrue(moduleList.contains(module2));
    }

    @Test
    public void testGetAllModules() {
        ModuleEntity module1 = new ModuleEntity();
        module1.setName("Module 1");
        moduleDao.saveAndFlush(module1);

        ModuleEntity module2 = new ModuleEntity();
        module2.setName("Module 2");
        moduleDao.saveAndFlush(module2);

        List<ModuleEntity> modules = moduleDao.findAll();

        assertEquals(2, modules.size());
    }
}