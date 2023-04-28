package com.backend.codenexus.dao;

import com.backend.codenexus.entity.QuestionEntity;
import com.backend.codenexus.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity, Long> {
    @Query(value ="SELECT q FROM QuestionEntity q WHERE q.quizID.quizID = ?1")
    List<QuestionEntity> findByQuizID(Long quiz);

    @Query(value = "SELECT q FROM QuestionEntity q WHERE q.questionID = :questionId")
    QuestionEntity findByQuesID(@Param("questionId") Long question);

    @Query("SELECT q.quizID.quizID FROM QuestionEntity q WHERE q.questionID = :questionId")
    QuizEntity findQuiz(@Param("questionId") Long questionId);
}
