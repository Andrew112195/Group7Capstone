package com.backend.codenexus.model;

import lombok.Data;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Data
public class User {
    private Long id;
    private Long userTypeId;
    private Long cohortId;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String verificationCode;
    private String resetPasswordToken;
    private String messages;
}
