package com.backend.codenexus.model;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private long id;

    private String answer;

    private long questionId;
}
