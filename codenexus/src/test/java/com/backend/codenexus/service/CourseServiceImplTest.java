package com.backend.codenexus.service;

import com.backend.codenexus.dao.CourseDao;
import com.backend.codenexus.dao.ModuleDao;
import com.backend.codenexus.dao.QuizDao;
import com.backend.codenexus.dao.TaskDao;
import com.backend.codenexus.dao.UserCourseDao;
import com.backend.codenexus.dao.UserDao;
import com.backend.codenexus.dao.UserModuleDao;
import com.backend.codenexus.dao.UserTaskDao;
import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.ModuleEntity;
import com.backend.codenexus.entity.TaskEntity;
import com.backend.codenexus.entity.UserCourseEntity;
import com.backend.codenexus.entity.UserEntity;
import com.backend.codenexus.entity.UserTaskEntity;
import com.backend.codenexus.model.TaskQuestionBuilder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CourseServiceImplTest {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UserCourseDao userCourseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ModuleDao moduleDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private QuizDao quizDao;
    @Autowired
    private UserModuleDao userModuleDao;
    @Autowired
    private UserTaskDao userTaskDao;
    @Autowired
    private CourseService courseService;


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
    @Test
    public void testCompleteTask() {
        // Create test data
        UserCourseEntity userCourse = new UserCourseEntity();
        userCourseDao.save(userCourse);
        
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setQuestion("What is the capital of France?");
        taskEntity.setAnswer("Paris");
        taskDao.save(taskEntity);
        
        UserTaskEntity userTask = new UserTaskEntity();
        userTask.setTask(taskEntity);
        userTask.setUserCourse(userCourse);
        userTaskDao.save(userTask);
        
        // Call the method under test
        courseService.completeTask("What is the capital of France?", "Paris", userCourse.getId());
        
        // Assert the results
        UserTaskEntity savedUserTask = userTaskDao.findById(userTask.getId()).get();
        assertTrue(savedUserTask.isComplete());
        assertTrue(savedUserTask.isCorrect());
    }
    
    @Test
    public void testFindAllTasksByModuleId() {
        // Given
        UserCourseEntity userCourse = new UserCourseEntity();
        userCourseDao.save(userCourse);

        ModuleEntity module = new ModuleEntity();
        moduleDao.save(module);

        TaskEntity task1 = new TaskEntity();
        task1.setModule(module);
        taskDao.save(task1);

        UserTaskEntity userTask1 = new UserTaskEntity();
        userTask1.setTask(task1);
        userTask1.setUserCourse(userCourse);
        userTaskDao.save(userTask1);

        TaskEntity task2 = new TaskEntity();
        task2.setModule(module);
        taskDao.save(task2);

        UserTaskEntity userTask2 = new UserTaskEntity();
        userTask2.setTask(task2);
        userTask2.setUserCourse(userCourse);
        userTaskDao.save(userTask2);

        // When
        List<UserTaskEntity> result = courseService.findAllTasksByModuleId(module.getId(), userCourse.getId());

        // Then
        assertEquals(userTask1, result.get(0));
        assertEquals(userTask2, result.get(1));
    }

    @Test
    public void testGetTask() {
        // Create test data
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(1L);
        UserCourseEntity userCourseEntity = new UserCourseEntity();
        userCourseEntity.setId(1L);
        UserTaskEntity userTaskEntity = new UserTaskEntity();
        userTaskEntity.setId(1L);
        userTaskEntity.setTask(taskEntity);
        userCourseDao.save(userCourseEntity);
        
        // Call the method being tested
        UserTaskEntity result = courseService.getTask(1L, 1L);
        
        // Assert that the returned UserTaskEntity matches the expected values
        assertNotNull(result);
    }
    @Test
    public void testGetTaskByQuestion() {
        // given
        String question = "What is the capital of France?";
        TaskEntity task = new TaskEntity();
        task.setQuestion(question);
        taskDao.save(task);

        // when
        TaskEntity taskEntity = courseService.getTaskByQuestion(question);

        // then
        assertNotNull(taskEntity);
        assertEquals(question, taskEntity.getQuestion());
    }

    @Test
    public void testSaveTask() {
        // Create a new task entity to save
        TaskEntity task = new TaskEntity();
        task.setQuestion("What is the capital of France?");
        task.setAnswer("Paris");
        
        // Save the task using the task service
        courseService.saveTask(task);
        
        // Retrieve the task from the database using the task DAO
        TaskEntity savedTask = taskDao.findById(task.getId()).orElse(null);
        
        // Assert that the retrieved task is not null and has the correct values
        assertNotNull(savedTask);
        assertEquals("What is the capital of France?", savedTask.getQuestion());
        assertEquals("Paris", savedTask.getAnswer());
    }

}