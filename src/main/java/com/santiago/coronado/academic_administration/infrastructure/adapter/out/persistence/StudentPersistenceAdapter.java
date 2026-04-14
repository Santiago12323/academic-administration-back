package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence;

import com.santiago.coronado.academic_administration.domain.model.Student;
import com.santiago.coronado.academic_administration.domain.port.out.StudentRepositoryPort;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper.StudentPersistenceMapper;
import com.santiago.coronado.academic_administration.infrastructure.repository.JpaStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentRepositoryPort {

    private final JpaStudentRepository repository;
    private final StudentPersistenceMapper mapper;

    @Override
    public Student save(Student student) {
        return mapper.toDomain(repository.save(mapper.toEntity(student)));
    }

    @Override
    public Optional<Student> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDomain);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}