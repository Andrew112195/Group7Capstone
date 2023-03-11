package com.backend.codenexus.model;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private Long id;
    private Long moduleId;
    private Long questionId;
    private boolean complete;
}
