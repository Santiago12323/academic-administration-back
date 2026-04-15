package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.controller;

import com.santiago.coronado.academic_administration.application.usecase.GradeUseCase;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.GradeRequestDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.GradeResponseDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper.GradeRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/grades")
@RequiredArgsConstructor
@Tag(name = "Calificaciones", description = "Operaciones para el registro y consulta de notas")
public class GradeController {

    private final GradeUseCase gradeUseCase;
    private final GradeRestMapper gradeMapper;

    @PostMapping
    @Operation(summary = "Registrar una nota")
    public ResponseEntity<GradeResponseDTO> register(
            @RequestBody GradeRequestDTO dto,
            @RequestParam String studentId,
            @RequestParam String subjectId
    ) {

        var domain = gradeUseCase.registerGrade(
                dto.getValue(),
                dto.getDescription(),
                studentId,
                subjectId
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gradeMapper.toDTO(domain));
    }


    @GetMapping("/student/{studentId}/subject/{subjectId}")
    @Operation(summary = "Consultar historial de notas", description = "Retorna todas las notas de un estudiante en una materia específica.")
    public ResponseEntity<List<GradeResponseDTO>> getGrades(
            @PathVariable String studentId,
            @PathVariable String subjectId) {

        List<GradeResponseDTO> response = gradeUseCase.getGradesByStudentAndSubject(studentId, subjectId)
                .stream()
                .map(gradeMapper::toDTO)
                .toList();

        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
}