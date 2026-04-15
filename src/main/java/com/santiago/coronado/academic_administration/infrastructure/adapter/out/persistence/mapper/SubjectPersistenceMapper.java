package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper;

import com.santiago.coronado.academic_administration.domain.model.Subject;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SubjectPersistenceMapper {

    @Named("toDomainBasic")
    @Mapping(target = "grades", ignore = true)
    Subject toDomain(SubjectEntity entity);

    @Named("toEntityBasic")
    @Mapping(target = "grades", ignore = true)
    SubjectEntity toEntity(Subject domain);
}