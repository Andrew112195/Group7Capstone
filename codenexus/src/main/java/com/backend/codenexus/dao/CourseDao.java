package com.backend.codenexus.dao;

import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CourseDao extends JpaRepository<CourseEntity,Long> {

    @Query(value = "SELECT * FROM course WHERE user_id = ?1", nativeQuery = true)
    List<CourseEntity> findAllByUserId(Long user_id);

    @Query(value = "SELECT * FROM course WHERE user_id = ?1 and is_completed = true", nativeQuery = true)
    List<CourseEntity> findAllCompletedByUserId(Long user_id);

    @Query(value = "SELECT * FROM course WHERE user_id = ?1 and is_completed = false", nativeQuery = true)
    List<CourseEntity> findAllIncompletedByUserId(Long user_id);

    @Query(value = "SELECT * FROM module WHERE course_id = ?1", nativeQuery = true)
    List<ModuleEntity> findAllModulesByCourseId(Long course_id);
}
