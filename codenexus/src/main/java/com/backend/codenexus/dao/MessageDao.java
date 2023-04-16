package com.backend.codenexus.dao;

import com.backend.codenexus.entity.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface MessageDao extends JpaRepository<MessagesEntity, Long> {

    @Query(value = "SELECT * FROM messages_entity WHERE id = ?1", nativeQuery = true)
    MessagesEntity findByMessageId(Long messageId);

}