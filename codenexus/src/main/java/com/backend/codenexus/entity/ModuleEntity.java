package com.backend.codenexus.entity;

import com.backend.codenexus.model.Difficulty;
import com.backend.codenexus.model.Modules;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    /*Many modules in one course*/
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseId;

    /*One Module to many questions*/
    @OneToMany(mappedBy = "module")
    private List<QuestionsEntity> questions;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="next_module")
    private String nextModule;

    @Column(name = "subject")
    private String subject;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "pre_req")
    private boolean preReq;

    @Column(name = "quiz_passed")
    private boolean quizPassed;

    @Column(name = "head_module")
    private boolean headModule;

    @Column(name = "last_module")
    private boolean lastModule;
}
