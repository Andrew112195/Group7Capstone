package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Question_ID")
    private long questionID;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private QuizEntity quizID;

    @Column(name = "Question_Content")
    private String questionContent;

    @Column(name = "Option1")
    private String  option1;

    @Column(name = "Option2")
    private String  option2;
    @Column(name = "Option3")
    private String  option3;
    @Column(name = "Question_Answer")
    private String answerNumber;
}
