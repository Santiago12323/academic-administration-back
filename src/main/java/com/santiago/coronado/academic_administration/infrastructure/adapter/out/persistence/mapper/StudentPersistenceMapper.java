package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper;

import com.santiago.coronado.academic_administration.domain.model.Student;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.StudentEntity;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    @Named("toDomainBasic")
    @Mapping(target = "grades", ignore = true)
    Student toDomain(StudentEntity entity);

    @Named("toDomainWithGrades")
    Student toDomainWithGrades(StudentEntity entity);

    @Named("toEntityBasic")
    @Mapping(target = "grades", ignore = true)
    StudentEntity toEntity(Student domain);
}