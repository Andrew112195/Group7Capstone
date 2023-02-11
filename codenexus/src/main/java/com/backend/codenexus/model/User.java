package com.backend.codenexus.model;
import lombok.Data;

@lombok.AllArgsConstructor
@Data
public class User {
    private long id;
    private UserType userTypeId;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String messages;
}
