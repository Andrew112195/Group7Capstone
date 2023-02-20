package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")

public class MessagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private UserEntity recipientId;

    @Column(name = "read")
    private boolean read;

    @Column(name = "sent")
    private boolean sent;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String message;

}
