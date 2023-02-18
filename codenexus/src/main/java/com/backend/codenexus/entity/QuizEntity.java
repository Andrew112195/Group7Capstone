package com.backend.codenexus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "module_id")
    private long moduleId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private long questionId;

    @Column(name = "passed")
    private boolean passed;
}
