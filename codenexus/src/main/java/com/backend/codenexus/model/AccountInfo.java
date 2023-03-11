package com.backend.codenexus.model;
import lombok.Data;

@Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class AccountInfo {

    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private int pointBalance;
}
