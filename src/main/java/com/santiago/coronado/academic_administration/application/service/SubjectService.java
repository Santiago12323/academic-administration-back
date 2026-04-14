package com.santiago.coronado.academic_administration.application.service;

import com.santiago.coronado.academic_administration.application.usecase.SubjectUseCase;
import com.santiago.coronado.academic_administration.domain.exception.BusinessRuleException;
import com.santiago.coronado.academic_administration.domain.model.Subject;
import com.santiago.coronado.academic_administration.domain.port.out.SubjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService implements SubjectUseCase {

    private final SubjectRepositoryPort subjectRepositoryPort;

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepositoryPort.save(subject);
    }

    @Override
    public Subject getSubjectById(String id) {
        return subjectRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    public Page<Subject> getAllSubjects(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return subjectRepositoryPort.findAll(pageable);
    }

    @Override
    public Subject updateSubject(String id, Subject subjectUpdate) {
        return subjectRepositoryPort.findById(id)
                .map(existingSubject -> {
                    Subject updatedSubject = Subject.builder()
                            .id(id)
                            .name(subjectUpdate.getName())
                            .code(subjectUpdate.getCode())
                            .credits(subjectUpdate.getCredits())
                            .grades(existingSubject.getGrades())
                            .build();

                    return subjectRepositoryPort.save(updatedSubject);
                })
                .orElseThrow(() -> new BusinessRuleException("Business Rule Violation: Subject not found with ID: " + id));
    }
}