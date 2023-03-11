package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Data
@Entity
@Table(name = "cohort")
public class CohortEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = UserEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cohort_id",referencedColumnName = "id")
    private List<UserEntity> users;
}
