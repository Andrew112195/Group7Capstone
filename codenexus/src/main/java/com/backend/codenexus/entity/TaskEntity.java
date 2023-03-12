package com.backend.codenexus.entity;

import com.backend.codenexus.model.enums;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /*We are in the task class*/
    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    @Column(name = "problem")
    private String question;

    @Column(name = "difficulty_level")
    private int difficultyLevel;

    @Column(name = "category")
    private String category;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "question_type")
    private String questionType;

    @Column(name = "complete")
    private boolean complete;

    public enums.Difficulty getDifficulty() {
        switch (difficultyLevel) {
            case 1:
                return enums.Difficulty.EASY;
            case 2:
                return enums.Difficulty.MEDIUM;
            case 3:
                return enums.Difficulty.HARD;
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + difficultyLevel);
        }
    }

    public void setDifficulty(enums.Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                difficultyLevel = 1;
                break;
            case MEDIUM:
                difficultyLevel = 2;
                break;
            case HARD:
                difficultyLevel = 3;
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + difficulty);
        }
    }
}
