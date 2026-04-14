package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper;

import com.santiago.coronado.academic_administration.domain.model.Grade;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.GradeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GradeRestMapper {

    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "subject.id", source = "subjectId")
    Grade toDomain(GradeDTO dto);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    GradeDTO toDTO(Grade grade);
}