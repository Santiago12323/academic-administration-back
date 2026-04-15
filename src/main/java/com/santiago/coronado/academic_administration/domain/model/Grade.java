package com.santiago.coronado.academic_administration.domain.model;

import com.santiago.coronado.academic_administration.domain.exception.BusinessRuleException;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Grade {
    private final String id;
    private final Double value;
    private final LocalDateTime registrationDate;
    private final Student student;
    private final Subject subject;
    private final String description;

    @Builder
    public Grade(String id, Double value, String description, LocalDateTime registrationDate, Student student, Subject subject) {
        validateValue(value);
        this.id = id;
        this.value = value;
        this.description = description;
        this.registrationDate = registrationDate != null ? registrationDate : LocalDateTime.now();
        this.student = student;
        this.subject = subject;
    }

    private void validateValue(Double value) {
        if (value == null || value < 1.0 || value > 5.0) {
            throw new BusinessRuleException("Business Rule Violation: Grade value must be between 1.0 and 5.0.");
        }
    }
}