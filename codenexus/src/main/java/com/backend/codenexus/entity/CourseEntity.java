package com.backend.codenexus.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;
    
    @Column(name="is_complete")
    private boolean isCompleted;

    @Column(name = "pre_requisites")
    private boolean preRequisites;

    @OneToMany(mappedBy = "course")
    private List<UserCourseEntity> userCourses;


    @JoinColumn(name = "quiz_id")
    @OneToOne(mappedBy = "courseQ")
    private QuizEntity quiz;

    @OneToMany(mappedBy = "course")
    private Set<TaskEntity> tasks;


}
