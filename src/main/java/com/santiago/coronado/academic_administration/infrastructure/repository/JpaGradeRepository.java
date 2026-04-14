package com.santiago.coronado.academic_administration.infrastructure.repository;

import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JpaGradeRepository extends JpaRepository<GradeEntity, String> {

    List<GradeEntity> findByStudentIdAndSubjectId(String studentId, String subjectId);

    List<GradeEntity> findByStudentId(String studentId);
}