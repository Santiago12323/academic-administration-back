package com.santiago.coronado.academic_administration.domain.port.out;

import com.santiago.coronado.academic_administration.domain.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentRepositoryPort {
    Student save(Student student);

    Optional<Student> findById(String id);

    Page<Student> findAll(Pageable pageable);

    void deleteById(String id);
}
