package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.mapper;

import com.santiago.coronado.academic_administration.domain.model.Subject;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.SubjectRequestDTO;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.SubjectResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectRestMapper {

    SubjectResponseDTO toDTO(Subject subject);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grades", ignore = true)
    Subject toDomain(SubjectRequestDTO dto);
}