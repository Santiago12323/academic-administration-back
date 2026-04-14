package com.santiago.coronado.academic_administration.application.service;

import com.santiago.coronado.academic_administration.domain.model.Grade;
import com.santiago.coronado.academic_administration.domain.port.out.GradeRepositoryPort;
import com.santiago.coronado.academic_administration.application.usecase.GradeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService implements GradeUseCase {

    private final GradeRepositoryPort gradeRepositoryPort;

    @Override
    public Grade registerGrade(Grade grade) {
        return gradeRepositoryPort.save(grade);
    }

    @Override
    public List<Grade> getGradesByStudentAndSubject(String studentId, String subjectId) {
        return gradeRepositoryPort.findByStudentAndSubject(studentId, subjectId);
    }
}