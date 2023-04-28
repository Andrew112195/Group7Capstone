package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_course")
public class UserCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @OneToMany
    @JoinColumn(name = "user_module_id")
    private List<UserModuleEntity> userModule;

    @OneToMany
    @JoinColumn(name = "user_task_id")
    private List<UserTaskEntity> userTask;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @Column(name="cohort")
    private String cohort;

    @Column(name="progress")
    private float progress;
}
