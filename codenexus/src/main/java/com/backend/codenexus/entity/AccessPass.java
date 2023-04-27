package com.backend.codenexus.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class AccessPass {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;

}
