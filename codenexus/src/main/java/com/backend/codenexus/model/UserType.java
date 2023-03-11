package com.backend.codenexus.model;
import lombok.Data;

@Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserType {

    private long id;
    private USER_TYPE userType;
    private long userId;
}
