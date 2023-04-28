package com.backend.codenexus.entity;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_module")
public class UserModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity moduleEntity;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "user_course_id")
    private UserCourseEntity userCourse;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_task_id")
    private List<UserTaskEntity> userTasks;

    @Column(name = "module_complete")
    private boolean moduleComplete;
}
