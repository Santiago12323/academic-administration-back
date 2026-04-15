package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.controller;

import com.santiago.coronado.academic_administration.application.usecase.StudentUseCase;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.StudentRequestDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.StudentResponseDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper.StudentRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Registrar un nuevo estudiante")
    @ApiResponse(responseCode = "201", description = "Estudiante creado correctamente")
    public ResponseEntity<StudentResponseDTO> create(@RequestBody StudentRequestDTO dto) {
        var domain = studentUseCase.createStudent(studentMapper.toDomain(dto));
        return new ResponseEntity<>(studentMapper.toDTO(domain), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            summary = "Obtener listado de estudiantes paginado y filtrado",
            description = "Retorna una página de estudiantes. Si se envía el parámetro 'search', filtra por nombre, apellido o ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Page<StudentResponseDTO>> getAll(
            @Parameter(description = "Número de página (desde 0)", example = "0")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Filtro opcional (Nombre, Apellido o ID)", example = "Santiago")
            @RequestParam(required = false) String search) {

        return ResponseEntity.ok(
                studentUseCase.getAllStudents(page, search)
                        .map(studentMapper::toDTO)
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estudiante por ID")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable String id) {
        var domain = studentUseCase.getStudentById(id);
        return ResponseEntity.ok(studentMapper.toDTO(domain));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar estudiante")
    public ResponseEntity<StudentResponseDTO> update(
            @PathVariable String id,
            @RequestBody StudentRequestDTO dto) {
        var domain = studentUseCase.updateStudent(id, studentMapper.toDomain(dto));
        return ResponseEntity.ok(studentMapper.toDTO(domain));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar estudiante")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        studentUseCase.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}