package com.santiago.coronado.academic_administration.application.usecase;

import com.santiago.coronado.academic_administration.domain.model.Grade;

import java.util.List;

public interface GradeUseCase {


    Grade registerGrade(Double value, String description,
                        String studentId, String subjectId);

    List<Grade> getGradesByStudentAndSubject(String studentId, String subjectId);
}
