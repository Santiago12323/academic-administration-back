package com.santiago.coronado.academic_administration.domain.port.out;

import com.santiago.coronado.academic_administration.domain.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SubjectRepositoryPort {
    Subject save(Subject subject);

    Optional<Subject> findById(String id);

    Page<Subject> findAll(Pageable pageable);
}
