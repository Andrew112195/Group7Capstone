package com.backend.codenexus.model;

import lombok.*;
import com.backend.codenexus.entity.UserEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private Long id;
    private UserEntity userId;
    private UserEntity recipientId;
    private boolean read;
    private boolean sent;
    private String header;
    private String message;
}
