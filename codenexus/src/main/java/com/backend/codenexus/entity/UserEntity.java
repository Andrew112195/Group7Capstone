package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import java.util.ArrayList;

@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor

public class UserEntity {

    @OneToMany(mappedBy = "userId")
    ArrayList <MessagesEntity> userMessages;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserTypeEntity userTypeId;

    @Column(name = "first_name")
    private String firstname;

   @Column(name = "last_name")
    private String lastname;

    @Column(name= "username")
    private String username;

   @Column(name = "password")
    private String password;

   @Column(name="messages")
    private String messages;

}
