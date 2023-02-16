package com.backend.codenexus.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billing {

    private long id;
    private long user_id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String country;
}