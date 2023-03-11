package com.backend.codenexus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlan {

    private Long id;
    private String planName;
    private String planDescription;
    private String planPrice;
    private String billingInterval;
}
