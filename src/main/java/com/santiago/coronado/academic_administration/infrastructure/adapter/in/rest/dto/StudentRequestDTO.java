package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@Schema(description = "Datos para crear o actualizar un estudiante")
public class StudentRequestDTO {

    @Schema(example = "Juan")
    private String firstName;

    @Schema(example = "Pérez")
    private String lastName;

    @Schema(example = "juan@gmail.com")
    private String email;

    @Schema(example = "2000-05-10")
    private LocalDate birthDate;
}