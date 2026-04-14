package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper;

import com.santiago.coronado.academic_administration.domain.model.Student;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.StudentEntity;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = {GradePersistenceMapper.class})
public interface StudentPersistenceMapper {

    @Mapping(target = "grades", source = "grades")
    Student toDomain(StudentEntity entity);

    @Mapping(target = "grades", source = "grades")
    StudentEntity toEntity(Student domain);
}