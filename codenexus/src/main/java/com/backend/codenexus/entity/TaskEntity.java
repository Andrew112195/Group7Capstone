package com.backend.codenexus.entity;

import com.backend.codenexus.model.Difficulty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Entity
@Table(name="task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity moduleId;

    @Column(name = "question")
    private String question;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "category")
    private String category;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "question_type")
    private String questionType;


}