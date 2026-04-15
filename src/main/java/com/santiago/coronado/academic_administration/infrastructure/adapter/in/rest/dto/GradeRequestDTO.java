package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Objeto para el registro de una nueva calificación")
public class GradeRequestDTO {

    @Schema(description = "Valor numérico de la nota (rango de 1.0 a 5.0)", example = "4.5", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double value;

    @Schema(description = "Descripción de la actividad o examen", example = "Parcial Final de Matemáticas", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

}