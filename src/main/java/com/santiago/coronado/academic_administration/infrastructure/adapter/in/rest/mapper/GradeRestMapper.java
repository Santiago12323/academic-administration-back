package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper;

import com.santiago.coronado.academic_administration.domain.model.Grade;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.GradeRequestDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.GradeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GradeRestMapper {

    Grade toDomain(GradeRequestDTO dto);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    GradeResponseDTO toDTO(Grade grade);
}