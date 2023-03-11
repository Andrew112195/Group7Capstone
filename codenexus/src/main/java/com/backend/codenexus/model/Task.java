package com.backend.codenexus.model;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Task {

    private int id;
    private String question;
    private Long answerId;
    private enums.Difficulty difficulty;
    private String category;
    private String explanation;
    private String questionType;

    private boolean complete;
}
