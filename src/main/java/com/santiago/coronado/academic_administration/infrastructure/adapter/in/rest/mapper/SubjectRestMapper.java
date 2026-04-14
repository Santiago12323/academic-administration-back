package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper;

import com.santiago.coronado.academic_administration.domain.model.Subject;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.SubjectDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectRestMapper {
    SubjectDTO toDTO(Subject subject);
    Subject toDomain(SubjectDTO dto);
}