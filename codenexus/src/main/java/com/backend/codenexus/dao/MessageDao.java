package com.backend.codenexus.dao;

import java.util.List;
import com.backend.codenexus.entity.MessagesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MessageDao extends JpaRepository<MessagesEntity, Long> {

    @Query(value = "SELECT * FROM messages_entity WHERE recipient_id = ?1", nativeQuery = true)
    List<MessagesEntity> findAllByUserId(Long userId);

    @Query(value = "SELECT * FROM messages_entity = ?1 WHERE sent = true", nativeQuery = true)
    List<MessagesEntity> findAllSentByUserId(Long userId);

}
