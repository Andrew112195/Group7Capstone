package com.backend.codenexus.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    private Long id;
    private Long userId;
    private Long planId;
    private Date startDate;
    private Date endDate;
    private boolean active;

}
