package com.santiago.coronado.academic_administration.application.usecase;

import com.santiago.coronado.academic_administration.domain.model.Subject;
import org.springframework.data.domain.Page;

public interface SubjectUseCase {
    Subject createSubject(Subject subject);

    Subject getSubjectById(String id);

    Page<Subject> getAllSubjects(int page);

    Subject updateSubject(String id, Subject subjectUpdate);
}
