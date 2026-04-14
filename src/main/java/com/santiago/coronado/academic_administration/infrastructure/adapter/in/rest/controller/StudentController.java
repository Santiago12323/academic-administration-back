package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.controller;

import com.santiago.coronado.academic_administration.application.usecase.StudentUseCase;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.StudentDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper.StudentRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Estudiantes", description = "Operaciones para la gestión de alumnos")
public class StudentController {

    private final StudentUseCase studentUseCase;
    private final StudentRestMapper studentMapper;

    @PostMapping
    @Operation(summary = "Registrar un nuevo estudiante", description = "Valida reglas de negocio como edad mínima y formato de email.")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        var domain = studentUseCase.createStudent(studentMapper.toDomain(dto));
        return new ResponseEntity<>(studentMapper.toDTO(domain), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estudiante por ID", description = "Retorna un error 400/404 si el estudiante no existe.")
    public ResponseEntity<StudentDTO> getById(@PathVariable String id) {
        var domain = studentUseCase.getStudentById(id);
        return ResponseEntity.ok(studentMapper.toDTO(domain));
    }

    @GetMapping
    @Operation(summary = "Listar todos los estudiantes", description = "Paginación fija de 5 registros por página.")
    public ResponseEntity<Page<StudentDTO>> getAll(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(studentUseCase.getAllStudents(page).map(studentMapper::toDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos de un estudiante", description = "Permite modificar nombres, email y fecha de nacimiento.")
    public ResponseEntity<StudentDTO> update(@PathVariable String id, @RequestBody StudentDTO dto) {
        var domain = studentUseCase.updateStudent(id, studentMapper.toDomain(dto));
        return ResponseEntity.ok(studentMapper.toDTO(domain));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un estudiante", description = "Eliminación física del registro por ID.")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        studentUseCase.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}