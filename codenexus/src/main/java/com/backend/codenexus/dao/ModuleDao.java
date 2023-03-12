package com.backend.codenexus.dao;

import java.util.List;

import com.backend.codenexus.entity.ModuleEntity;
import com.backend.codenexus.entity.QuizEntity;
import com.backend.codenexus.entity.TaskEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleDao extends JpaRepository<ModuleEntity, Long> {

    @Query(value = "SELECT * FROM task_entity WHERE module_id = ?1", nativeQuery = true)
     List<TaskEntity> findTasksByModuleId(Long module_id);

    @Query(value = "SELECT * FROM task_entity WHERE module_id = ?1", nativeQuery = true)
    TaskEntity findTaskById(Long module_Id);

    @Query(value = "SELECT * FROM quiz_entity WHERE module_id = ?1", nativeQuery = true)
    QuizEntity findQuizById(Long module_id);
}
