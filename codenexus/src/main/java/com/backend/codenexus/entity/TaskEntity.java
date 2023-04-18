package com.backend.codenexus.entity;

import com.backend.codenexus.model.enums;
import jakarta.persistence.*;
import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    @Column(name="question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "difficulty_level")
    private int difficultyLevel;

    @Column(name = "complete")
    private boolean complete;

    private boolean isCorrect;

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

    private String[] taskContents;

    @SuppressWarnings("null")
    public String[] setTaskContents(){
        String[] wholeLesson;
        String allText = null;



        try {
            File myObj = new File("/Users/andrewshapiro/IdeaProjects/TestingQuestions/src/SampleQuestions.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                allText += data;
                allText += "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(allText);

        wholeLesson = allText.split("%");

        for (int i = 0; i < wholeLesson.length; i++) {
            System.out.println(wholeLesson[i]);
        }
        return this.taskContents;
    }
}