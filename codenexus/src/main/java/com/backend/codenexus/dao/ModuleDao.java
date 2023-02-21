package com.backend.codenexus.dao;

import java.util.List;
import com.backend.codenexus.entity.ModuleEntity;
import com.backend.codenexus.entity.TaskEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleDao extends JpaRepository<ModuleEntity, Long> {
    
    @Query(value = "SELECT * FROM Module WHERE user_id = ?1", nativeQuery = true)
    List<ModuleEntity> findAllByUserId(Long userId);

    @Query(value = "SELECT * FROM Task WHERE module_id = ?1", nativeQuery = true)
     List<TaskEntity> findTasksByModuleId(Long moduleId);

}
