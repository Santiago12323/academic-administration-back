package com.santiago.coronado.academic_administration.domain.port.out;

import com.santiago.coronado.academic_administration.domain.model.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeRepositoryPort {
    Grade save(Grade grade);

    List<Grade> findByStudentAndSubject(String studentId, String subjectId);

    List<Grade> findByStudent(String studentId);

    Optional<Grade> findById(String id);

    void deleteById(String id);
}
