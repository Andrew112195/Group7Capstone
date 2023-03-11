package com.backend.codenexus.entity;

import com.backend.codenexus.entity.CourseEntity;
import com.backend.codenexus.model.Difficulty;
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
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @Column(name = "problem")
    private String Question;

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

    public Difficulty getDifficulty() {
        switch (difficultyLevel) {
            case 1:
                return Difficulty.EASY;
            case 2:
                return Difficulty.MEDIUM;
            case 3:
                return Difficulty.HARD;
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + difficultyLevel);
        }
    }

    public void setDifficulty(Difficulty difficulty) {
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
