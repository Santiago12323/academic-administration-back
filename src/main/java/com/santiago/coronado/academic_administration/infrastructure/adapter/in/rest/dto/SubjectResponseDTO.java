package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Respuesta de una asignatura")
public class SubjectResponseDTO {

    @Schema(description = "ID de la materia", example = "uuid-subject-123")
    private String id;

    @Schema(description = "Nombre de la materia", example = "Matemáticas")
    private String name;

    @Schema(description = "Código único de la materia", example = "MAT101")
    private String code;

    @Schema(description = "Número de créditos", example = "3")
    private Integer credits;
}