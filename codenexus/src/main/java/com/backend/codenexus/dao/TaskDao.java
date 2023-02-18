package com.backend.codenexus.dao;

import java.util.List;
import com.backend.codenexus.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<TaskEntity, Long>{
    
    @Query(value = "SELECT * FROM task WHERE module_id = ?1", nativeQuery = true)
    List<TaskEntity> findAllByModuleId(Long moduleId);
}
