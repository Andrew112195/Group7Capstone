package com.backend.codenexus.entity;

import com.backend.codenexus.model.enums;
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
    private Long id;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    @Column(name="task_name")
    private String taskName;

    @Column(name="question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "difficulty_level")
    private int difficultyLevel;

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