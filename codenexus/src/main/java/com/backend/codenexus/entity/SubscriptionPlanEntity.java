package com.backend.codenexus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SubscriptionPlan")
public class SubscriptionPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy ="plan")
    private SubscriptionEntity subscription;

    @Column(name = "plan_name")
    private String planName;
    @Column(name = "plan_description")
    private String planDescription;
    @Column(name = "plan_price")
    private String planPrice;
    @Column(name = "billing_interval")
    private String billingInterval;
}
