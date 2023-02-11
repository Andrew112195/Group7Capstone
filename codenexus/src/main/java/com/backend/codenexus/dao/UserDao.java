package com.backend.codenexus.dao;

import com.backend.codenexus.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


//Data Access Object

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
    UserEntity findById(long user_id);
}
