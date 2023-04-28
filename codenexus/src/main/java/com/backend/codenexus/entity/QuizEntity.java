package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz")
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Quiz_ID")
    private long quizID;

    @Column(name = "Quiz_Name")
    private String quizName;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quizID")
    private List<QuestionEntity> questions;

    private boolean complete;

    @OneToOne(mappedBy = "quiz")
    private ModuleEntity module;

    @Column(name = "score")
    private int score;
}
