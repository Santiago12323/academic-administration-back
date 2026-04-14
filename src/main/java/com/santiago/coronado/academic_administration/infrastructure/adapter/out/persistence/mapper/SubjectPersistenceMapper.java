package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper;

import com.santiago.coronado.academic_administration.domain.model.Subject;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GradePersistenceMapper.class})
public interface SubjectPersistenceMapper {

    @Mapping(target = "grades", source = "grades")
    Subject toDomain(SubjectEntity entity);

    @Mapping(target = "grades", source = "grades")
    SubjectEntity toEntity(Subject domain);
}