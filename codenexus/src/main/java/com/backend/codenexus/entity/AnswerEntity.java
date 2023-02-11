package com.backend.codenexus.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="answers")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "answer",nullable=false)
    private String answer;

    @OneToOne
    @JoinColumn(name="question_id")
    private QuestionsEntity question;

}
