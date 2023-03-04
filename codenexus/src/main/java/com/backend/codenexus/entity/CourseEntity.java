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
    private Long id;

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

    @Column(name = "user_id")
    private Long userId;

    /*
    * One Course can have many modules
    * */
    @OneToMany(mappedBy = "courseId")
    private Set<ModuleEntity> modules;
}
