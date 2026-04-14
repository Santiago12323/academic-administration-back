package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class StudentDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
}