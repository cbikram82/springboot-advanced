package com.spring.bikram.boot.tutorial.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class EmployeeResponse {
    private Long employeeID;
    private String employeeName;
    private String employeeLocation;
} 