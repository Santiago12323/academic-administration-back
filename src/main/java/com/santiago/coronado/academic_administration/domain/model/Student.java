package com.santiago.coronado.academic_administration.domain.model;

import com.santiago.coronado.academic_administration.domain.exception.BusinessRuleException;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

@Getter
public class Student {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate birthDate;
    private final List<Grade> grades;

    @Builder
    public Student(String id, String firstName, String lastName, String email, LocalDate birthDate, List<Grade> grades) {
        validateEmail(email);
        validateAge(birthDate);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.grades = grades;
    }

    private void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new BusinessRuleException("Business Rule Violation: Invalid email format.");
        }
    }

    private void validateAge(LocalDate birthDate) {
        if (birthDate != null && birthDate.isAfter(LocalDate.now().minusYears(5))) {
            throw new BusinessRuleException("Business Rule Violation: Student must be at least 5 years old.");
        }
    }
}