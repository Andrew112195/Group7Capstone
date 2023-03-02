package com.backend.codenexus.model;

import lombok.Data;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Data
public class User {
    private long id;
    private long userTypeId;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String messages;
}
