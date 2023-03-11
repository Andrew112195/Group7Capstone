package com.backend.codenexus.model;
import lombok.Data;

@Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserType {

    private Long id;
    private enums.USER_TYPE userType;
    private Long userId;
}
