package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.controller;

import com.santiago.coronado.academic_administration.application.usecase.GradeUseCase;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.GradeDTO;
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
    @Operation(summary = "Registrar una nota", description = "Valida que la nota esté en el rango de 0.0 a 5.0.")
    public ResponseEntity<GradeDTO> register(@RequestBody GradeDTO dto) {
        var domain = gradeUseCase.registerGrade(gradeMapper.toDomain(dto));
        return new ResponseEntity<>(gradeMapper.toDTO(domain), HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}/subject/{subjectId}")
    @Operation(summary = "Consultar historial de notas", description = "Retorna todas las notas de un estudiante en una materia específica.")
    public ResponseEntity<List<GradeDTO>> getGrades(
            @PathVariable String studentId,
            @PathVariable String subjectId) {

        var grades = gradeUseCase.getGradesByStudentAndSubject(studentId, subjectId)
                .stream()
                .map(gradeMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(grades);
    }
}