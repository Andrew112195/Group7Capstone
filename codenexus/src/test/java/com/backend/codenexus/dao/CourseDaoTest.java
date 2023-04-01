package com.backend.codenexus.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.ModuleEntity;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CourseDaoTest {
    
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ModuleDao moduleDao;

    @Test
    void testFindAll() {
        CourseEntity courseEntity = CourseEntity.builder()
        .title("course")
        .description("null")
        .price(0.0).build();
        CourseEntity courseEntity2 = CourseEntity.builder()
        .title("course2")
        .description("null")
        .price(0.0).build();

        courseDao.saveAndFlush(courseEntity);
        courseDao.saveAndFlush(courseEntity2);

        List<CourseEntity> listCourseEntity = courseDao.findAll();

        Assertions.assertNotNull(listCourseEntity);
        Assertions.assertEquals(2, listCourseEntity.size());
        

    }

    @Test
    void testFindAllModulesByCourseId() {
        CourseEntity courseEntity = CourseEntity.builder()
        .title("course")
        .description("null")
        .price(0.0).build();

        ModuleEntity moduleEntity = ModuleEntity.builder()
        .courseId(courseEntity).build();

        courseDao.saveAndFlush(courseEntity);
        moduleDao.saveAndFlush(moduleEntity);

        List<ModuleEntity> modules = courseDao.findAllModulesByCourseId(courseEntity.getId());

        Assertions.assertNotNull(modules);
        Assertions.assertEquals(1, modules.size());
    }
}
