package com.backend.codenexus.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_info")
public class PaymentInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "billing_id")
    private BillingEntity billing;
    private String firstName;

    private String lastName;

    private String cardType;

    private String cardNumber;

    private String cvv;
}
