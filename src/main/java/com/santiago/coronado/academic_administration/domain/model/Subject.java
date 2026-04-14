package com.santiago.coronado.academic_administration.domain.model;

import com.santiago.coronado.academic_administration.domain.exception.BusinessRuleException;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
public class Subject {
    private final String id;
    private final String name;
    private final String code;
    private final Integer credits;
    private final List<Grade> grades;

    @Builder
    public Subject(String id, String name, String code, Integer credits, List<Grade> grades) {
        validateCode(code);
        validateCredits(credits);
        this.id = id;
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.grades = grades;
    }

    private void validateCode(String code) {
        if (code == null || code.isBlank()) {
            throw new BusinessRuleException("Business Rule Violation: Subject code is required.");
        }
        if (code.trim().length() < 3) {
            throw new BusinessRuleException("Business Rule Violation: Subject code must be at least 3 characters long.");
        }
    }

    private void validateCredits(Integer credits) {
        if (credits == null || credits <= 0) {
            throw new BusinessRuleException("Business Rule Violation: Credits must be a positive number.");
        }
        if (credits > 10) {
            throw new BusinessRuleException("Business Rule Violation: Subject credits cannot exceed 10.");
        }
    }
}