package com.backend.codenexus.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.codenexus.entity.ModuleEntity;
import com.backend.codenexus.entity.TaskEntity;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TaskDaoTest {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private ModuleDao moduleDao;

    @Test
    public void testFindAllByModuleId() {
        Long moduleId = 1L;
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleDao.saveAndFlush(moduleEntity);
    
        TaskEntity task1 = new TaskEntity();
        TaskEntity task2 = new TaskEntity();
        task1.setModule(moduleEntity);
        task2.setModule(moduleEntity);
        taskDao.saveAndFlush(task1);
        taskDao.saveAndFlush(task2);
        List<TaskEntity> tasks = taskDao.findAllByModuleId(moduleId);
        Assertions.assertNotNull(tasks);
        Assertions.assertEquals(2, tasks.size());
    }
}