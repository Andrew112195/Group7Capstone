package com.backend.codenexus.entity;

import com.backend.codenexus.model.enums.Difficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "module")
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /* Many modules in one course */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseId;

    /* One Module to many tasks  */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id")
    private List<TaskEntity> tasks;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "module_complete")
    private boolean moduleComplete;
}