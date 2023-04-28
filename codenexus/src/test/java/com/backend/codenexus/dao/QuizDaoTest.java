package com.backend.codenexus.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.codenexus.entity.QuizEntity;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class QuizDaoTest {
    @Autowired
    private QuizDao quizDao;

    @Test
    public void testFindByQuizId() {
        Long quizId = 1L;
        QuizEntity newQuiz = new QuizEntity();
        quizDao.saveAndFlush(newQuiz);

        QuizEntity quiz = quizDao.findByQuizId(quizId);

        Assertions.assertNotNull(quiz);
        Assertions.assertEquals(quizId, quiz.getId());
    }
}
