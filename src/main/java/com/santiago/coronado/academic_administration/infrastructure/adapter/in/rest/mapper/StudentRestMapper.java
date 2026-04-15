package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper;

import com.santiago.coronado.academic_administration.domain.model.Student;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.StudentRequestDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.StudentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentRestMapper {

    StudentResponseDTO toDTO(Student student);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grades", ignore = true)
    Student toDomain(StudentRequestDTO dto);
}