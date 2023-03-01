package com.backend.codenexus.model;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private long id;
    private long moduleId;
    private long questionId;
    private boolean complete;
}
