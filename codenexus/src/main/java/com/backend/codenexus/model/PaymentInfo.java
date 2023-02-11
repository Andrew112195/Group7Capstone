package com.backend.codenexus.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

    private long id;
    private long billingId;
    private String firstName;

    private String lastName;

    private String cardType;

    private String cardNumber;

    private String cvv;
}
