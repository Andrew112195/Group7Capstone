package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz")
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = CourseEntity.class,cascade = CascadeType.ALL)
    private CourseEntity courseQ;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "complete")
    private boolean complete;
}
