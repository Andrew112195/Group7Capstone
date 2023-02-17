package com.backend.codenexus.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messsage")


public class MessagesEntity {
    

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(name = "recipient_id")
    private long recipientId;

    @Column(name = "read")
    private boolean read;

    @Column(name = "sent")
    private boolean sent;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String message;

}
