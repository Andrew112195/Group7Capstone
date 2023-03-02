/*
package com.backend.codenexus.entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_type")
@Entity

public class UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name")
    private String typeName;


    */
/*A bunch of users under one user type Example Jay and Bob are Admins..........
    * Tim and robin are Students*//*

    @OneToMany(mappedBy = "id")
    private List<UserEntity> users;
}*/
