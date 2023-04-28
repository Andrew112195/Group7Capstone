package com.backend.codenexus.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.ModuleEntity;
import com.backend.codenexus.entity.QuizEntity;
import com.backend.codenexus.entity.TaskEntity;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ModuleDaoTest {

    @Autowired
    private ModuleDao moduleDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private QuizDao quizDao;

    @Test
    public void testFindTasksByModuleId() {
        Long moduleId = 1L;
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleDao.saveAndFlush(moduleEntity);
    
        TaskEntity task1 = new TaskEntity();
        TaskEntity task2 = new TaskEntity();
        task1.setModule(moduleEntity);
        task2.setModule(moduleEntity);
        taskDao.saveAndFlush(task1);
        taskDao.saveAndFlush(task2);

        List<TaskEntity> tasks = moduleDao.findTasksByModuleId(moduleId);

        Assertions.assertNotNull(tasks);
        Assertions.assertEquals(2, tasks.size());
    }

    @Test
    public void testFindTaskById() {
        Long taskId = 1L;
        TaskEntity newTask = new TaskEntity();
        taskDao.saveAndFlush(newTask);

        TaskEntity task = moduleDao.findTaskById(taskId);

        Assertions.assertNotNull(task);
        Assertions.assertEquals(taskId, task.getId());
    }

    @Test
    public void testFindQuizById() {
        Long courseId = 1L;
        CourseEntity course = new CourseEntity();
        QuizEntity newQuiz = new QuizEntity();
        newQuiz.setCourseQ(course);
        quizDao.saveAndFlush(newQuiz);

        QuizEntity quiz = moduleDao.findQuizById(courseId);

        Assertions.assertNotNull(quiz);
        Assertions.assertEquals(courseId, quiz.getCourseQ().getId());
    }

    @Test
    public void testFindTaskByQuestion() {
        String question = "question";
        TaskEntity targetTask = new TaskEntity();
        targetTask.setQuestion(question);
        taskDao.saveAndFlush(targetTask);

        TaskEntity task = moduleDao.findTaskByQuestion(question);

        Assertions.assertNotNull(task);
        Assertions.assertEquals(question, task.getQuestion());
    }
}