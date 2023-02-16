package com.backend.codenexus.entity;
import com.backend.codenexus.model.Messages;
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
    private MessagesEntity userId;

    
}
