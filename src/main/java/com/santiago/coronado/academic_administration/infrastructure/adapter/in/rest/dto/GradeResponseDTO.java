package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Respuesta detallada de una calificación registrada")
public class GradeResponseDTO {

    @Schema(description = "ID único de la calificación (UUID)", example = "550e8400-e29b-41d4-a716-446655440000")
    private String id;

    @Schema(description = "Valor de la nota", example = "4.5")
    private Double value;

    @Schema(description = "Descripción de la actividad", example = "Parcial Final de Matemáticas")
    private String description;

    @Schema(description = "Fecha y hora de registro del sistema")
    private LocalDateTime registrationDate;

    @Schema(description = "ID del estudiante asociado", example = "6b83f9f2-2e1d-4f1e-9e1d-3f1e9e1d3f1e")
    private String studentId;

    @Schema(description = "ID de la materia asociada", example = "1a2b3c4d-5e6f-7g8h-9i0j-1k2l3m4n5o6p")
    private String subjectId;
}