package com.backend.codenexus.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class MessagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id")
    private UserEntity recipientId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column//(nullable = false)
    private Date timeSent;

    @PrePersist
    private void onCreate(){
        timeSent = new Date();
    }
    @Column(name = "read")
    private boolean read = false;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String message;

    @Column(name = "announcement")
    private boolean isAnnouncement = false;
}
