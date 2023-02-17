package com.backend.codenexus.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    private long id;
    private long userId;
    private long planId;
    private Date startDate;
    private Date endDate;
    private boolean active;

}
