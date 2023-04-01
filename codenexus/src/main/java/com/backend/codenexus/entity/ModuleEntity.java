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

    private void addTaskToModule(TaskEntity taskEntity){
        this.tasks.add(taskEntity);
    }
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "difficulty")
    private Difficulty difficulty;

/*    @Column(name = "pre_req")
    private boolean preReq;*/


    @Column(name = "module_complete")
    private boolean moduleComplete;
}
