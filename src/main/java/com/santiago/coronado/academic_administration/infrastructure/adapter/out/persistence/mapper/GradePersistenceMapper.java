package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper;

import com.santiago.coronado.academic_administration.domain.model.Grade;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.GradeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {StudentPersistenceMapper.class, SubjectPersistenceMapper.class})
public interface GradePersistenceMapper {

    @Mapping(target = "student", qualifiedByName = "toEntityBasic")
    @Mapping(target = "subject", qualifiedByName = "toEntityBasic")
    GradeEntity toEntity(Grade domain);

    @Mapping(target = "student", qualifiedByName = "toDomainBasic")
    @Mapping(target = "subject", qualifiedByName = "toDomainBasic")
    Grade toDomain(GradeEntity entity);

    List<Grade> toDomainList(List<GradeEntity> entities);
}