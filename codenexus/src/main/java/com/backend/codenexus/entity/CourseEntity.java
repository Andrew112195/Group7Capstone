package com.backend.codenexus.entity;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name="isComplete")
    private boolean isCompleted;

    @Column(name = "preRequisites")
    private boolean preRequisites;

    @OneToMany(mappedBy = "courseId")
    private Set<UserCourseEntity> userCourses;

    /*
    * One Course can have many modules
    * */
    @OneToMany(mappedBy = "courseId")
    private Set<ModuleEntity> modules;
}