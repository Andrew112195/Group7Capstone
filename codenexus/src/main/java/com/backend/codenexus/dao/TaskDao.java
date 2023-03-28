package com.backend.codenexus.dao;

import com.backend.codenexus.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<TaskEntity, Long>{
    
    @Query(value = "SELECT * FROM task WHERE module_id = ?1 ORDER BY difficulty_level ASC ", nativeQuery = true)
    List<TaskEntity> findAllByModuleId(Long moduleId);


}
