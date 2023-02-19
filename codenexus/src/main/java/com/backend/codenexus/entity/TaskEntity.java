package com.backend.codenexus.entity;

import com.backend.codenexus.model.Difficulty;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity moduleId;

    @Column(name = "problem")
    private String[] problem;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "category")
    private String category;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "question_type")
    private String questionType;

}