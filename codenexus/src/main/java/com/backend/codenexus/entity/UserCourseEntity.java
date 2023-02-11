package com.backend.codenexus.entity;
import jakarta.persistence.*;
import lombok.*;
import com.backend.codenexus.model.Course;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_course")
public class UserCourseEntity {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;


    @Column(name="progress")
    private float progress;
}
