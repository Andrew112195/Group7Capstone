package com.backend.codenexus.model;

import lombok.Data;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Data
public class Cohort {
    private Long id;
    private String name;
    private Long userTypeId;
}
