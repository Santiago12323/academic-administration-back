package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GradeDTO {
    private String id;
    private Double value;
    private String description;
    private String studentId;
    private String subjectId;
}