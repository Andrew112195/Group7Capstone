package com.backend.codenexus.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "course_id")
    private List<UserCourseEntity> userCourses;

    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "course_id")
    private List<ModuleEntity> modules;

}