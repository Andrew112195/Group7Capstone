package com.backend.codenexus.dao;

import com.backend.codenexus.entity.QuizEntity;
import com.backend.codenexus.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao  extends JpaRepository<QuizEntity, Long> {

    @Query(value = "SELECT q FROM QuestionEntity q WHERE q.quizID.quizID = ?1")
    QuizEntity findByQuizId(Long quiz_id);


}