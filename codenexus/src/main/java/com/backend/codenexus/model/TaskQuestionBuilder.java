package com.backend.codenexus.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskQuestionBuilder {

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private Long taskEntity_id;
}
