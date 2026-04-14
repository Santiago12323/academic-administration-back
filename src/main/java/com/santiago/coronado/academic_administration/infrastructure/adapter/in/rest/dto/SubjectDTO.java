package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectDTO {
    private String id;
    private String name;
    private String code;
    private Integer credits;
}