package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Datos necesarios para crear o actualizar una asignatura")
public class SubjectRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre de la materia", example = "Matemáticas", required = true)
    private String name;

    @NotBlank(message = "El código es obligatorio")
    @Schema(description = "Código único de la materia", example = "MAT101", required = true)
    private String code;

    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "Los créditos deben ser mayores a 0")
    @Schema(description = "Número de créditos", example = "3", required = true)
    private Integer credits;
}