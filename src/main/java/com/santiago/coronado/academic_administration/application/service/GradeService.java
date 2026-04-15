package com.santiago.coronado.academic_administration.application.service;

import com.santiago.coronado.academic_administration.application.usecase.StudentUseCase;
import com.santiago.coronado.academic_administration.application.usecase.SubjectUseCase;
import com.santiago.coronado.academic_administration.domain.model.Grade;
import com.santiago.coronado.academic_administration.domain.model.Student;
import com.santiago.coronado.academic_administration.domain.model.Subject;
import com.santiago.coronado.academic_administration.domain.port.out.GradeRepositoryPort;
import com.santiago.coronado.academic_administration.application.usecase.GradeUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GradeService implements GradeUseCase {

    private final GradeRepositoryPort gradeRepositoryPort;
    private final StudentUseCase studentUseCase;
    private final SubjectUseCase subjectUseCase;


    @Override
    public Grade registerGrade(Double value, String description, String studentId, String subjectId) {
        Student student = studentUseCase.getStudentById(studentId);
        Subject subject = subjectUseCase.getSubjectById(subjectId);

        Grade grade = Grade.builder()
                .value(value)
                .description(description)
                .student(student)
                .subject(subject)
                .build();

        return gradeRepositoryPort.save(grade);
    }

    @Override
    public List<Grade> getGradesByStudentAndSubject(String studentId, String subjectId) {
        return gradeRepositoryPort.findByStudentAndSubject(studentId, subjectId);
    }
}