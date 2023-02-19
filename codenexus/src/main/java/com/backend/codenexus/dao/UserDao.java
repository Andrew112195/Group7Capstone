package com.backend.codenexus.dao;

import com.backend.codenexus.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

//Data Access Object
@EnableJpaRepositories
@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM user_entity WHERE user_id = ?1", nativeQuery = true)
    UserEntity findById(long user_id);

    @Query(value = "SELECT * FROM user_entity WHERE username = ?1", nativeQuery = true)
    UserEntity findByUsername(String username);
}
