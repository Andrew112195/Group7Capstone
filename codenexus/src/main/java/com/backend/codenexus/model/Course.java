package com.backend.codenexus.model;
import lombok.Data;

@Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Course {

    private long id;
    private String title;
    private String description;
    private boolean isCompleted;
    private boolean preRequisites;
}
