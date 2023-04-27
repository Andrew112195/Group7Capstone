package com.backend.codenexus.service;

import com.backend.codenexus.entity.QuestionEntity;
import com.backend.codenexus.entity.QuizEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizServiceInt {
    List<QuestionEntity> getQuestionsForQuiz(QuizEntity quiz);
}
