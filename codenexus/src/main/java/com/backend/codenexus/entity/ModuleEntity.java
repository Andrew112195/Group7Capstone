package com.backend.codenexus.entity;

import java.util.List;
import com.backend.codenexus.model.Difficulty;
import com.backend.codenexus.model.Module;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "module")
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /* Many modules in one course */
    @ManyToOne
    @JoinColumn(name = "courseId")
    private CourseEntity courseId;

    /* One Module to many questions */
    @OneToMany(mappedBy = "moduleId")
    private List<TaskEntity> tasks;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "pre_req")
    private boolean preReq;

    @Column(name = "module_complete")
    private boolean moduleComplete;
}
