package com.backend.codenexus.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCourse {
    private long id;
    private Course course;
    private User user;
    private float progress;
}
