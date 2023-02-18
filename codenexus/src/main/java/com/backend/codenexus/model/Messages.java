package com.backend.codenexus.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages {

    public long id;
    private long userId;
    private long recipientId;
    private boolean read;
    private boolean sent;
    private String header;
    private String message;
}
