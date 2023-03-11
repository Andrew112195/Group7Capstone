package com.backend.codenexus.dao;

import com.backend.codenexus.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao  extends JpaRepository<QuizEntity, Long> {

    @Query(value = "SELECT * FROM quiz_entity WHERE quiz_id = ?1", nativeQuery = true)
    QuizEntity findByQuizId(Long quiz_id);
}
