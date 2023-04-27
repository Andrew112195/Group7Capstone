package com.backend.codenexus.service;

import com.backend.codenexus.dao.QuestionDao;
import com.backend.codenexus.entity.QuestionEntity;
import com.backend.codenexus.entity.QuizEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService implements QuizServiceInt{
    @Autowired
    private QuestionDao questionRepo;

    public QuizService()
    {
        super();
    }

    /*This is a method that takes a QuizEntity object as a parameter
    and returns a list of QuestionEntity objects from the database
    that are associated with the given quiz. */
    @Override
    public List<QuestionEntity> getQuestionsForQuiz(QuizEntity quiz)
    {
        return questionRepo.findByQuizID(quiz);
    }

}
