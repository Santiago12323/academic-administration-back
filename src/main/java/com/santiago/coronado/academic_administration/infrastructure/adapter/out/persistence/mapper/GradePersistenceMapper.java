package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper;

import com.santiago.coronado.academic_administration.domain.model.Grade;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.GradeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GradePersistenceMapper {

    Grade toDomain(GradeEntity entity);

    GradeEntity toEntity(Grade domain);
}