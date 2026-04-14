package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.controller;

import com.santiago.coronado.academic_administration.application.usecase.SubjectUseCase;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.SubjectDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper.SubjectRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
@Tag(name = "Materias", description = "Operaciones para la gestión del catálogo de asignaturas")
public class SubjectController {

    private final SubjectUseCase subjectUseCase;
    private final SubjectRestMapper subjectMapper;

    @PostMapping
    @Operation(summary = "Crear una asignatura", description = "Requiere un código único y créditos mayores a cero.")
    public ResponseEntity<SubjectDTO> create(@RequestBody SubjectDTO dto) {
        var domain = subjectUseCase.createSubject(subjectMapper.toDomain(dto));
        return new ResponseEntity<>(subjectMapper.toDTO(domain), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar asignatura por ID")
    public ResponseEntity<SubjectDTO> getById(@PathVariable String id) {
        var domain = subjectUseCase.getSubjectById(id);
        return ResponseEntity.ok(subjectMapper.toDTO(domain));
    }

    @GetMapping
    @Operation(summary = "Listar materias paginadas", description = "Muestra 5 asignaturas por página por defecto.")
    public ResponseEntity<Page<SubjectDTO>> getAll(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(subjectUseCase.getAllSubjects(page).map(subjectMapper::toDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar información de la materia")
    public ResponseEntity<SubjectDTO> update(@PathVariable String id, @RequestBody SubjectDTO dto) {
        var domain = subjectUseCase.updateSubject(id, subjectMapper.toDomain(dto));
        return ResponseEntity.ok(subjectMapper.toDTO(domain));
    }
}