package com.backend.codenexus.entity;

import jakarta.persistence.*;

import lombok.*;

import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_course")
public class UserCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @Column(name="cohort")
    private String cohort;

    @Column(name="progress")
    private float progress;
}
