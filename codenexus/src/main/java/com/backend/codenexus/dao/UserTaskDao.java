package com.backend.codenexus.dao;

import com.backend.codenexus.entity.UserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskDao  extends JpaRepository<UserTaskEntity, Long> {
    
}