package com.backend.codenexus.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

    private Long id;
    private Long billingId;
    private String firstName;

    private String lastName;

    private String cardType;

    private String cardNumber;

    private String cvv;
}
