package com.santiago.coronado.academic_administration.infrastructure.repository;

import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStudentRepository extends JpaRepository<StudentEntity, String> {
}