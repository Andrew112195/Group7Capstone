package com.backend.codenexus.dao;

import com.backend.codenexus.entity.MessagesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface MessageDao extends JpaRepository<MessagesEntity, Long> {

    @Query(value = "SELECT * FROM messages_entity WHERE recipient_id = ?1", nativeQuery = true)
    List<MessagesEntity> findAllByUserId(Long userId);

    @Query(value = "SELECT * FROM messages_entity WHERE id = ?1", nativeQuery = true)
    MessagesEntity findByMessageId(Long messageId);

    @Query(value = "SELECT * FROM messages_entity WHERE user_id = ?1", nativeQuery = true)
    List<MessagesEntity> findAllSentByUserId(Long userId);

}
