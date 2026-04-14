package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper;

import com.santiago.coronado.academic_administration.domain.model.Student;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentRestMapper {
    StudentDTO toDTO(Student student);
    Student toDomain(StudentDTO dto);
}