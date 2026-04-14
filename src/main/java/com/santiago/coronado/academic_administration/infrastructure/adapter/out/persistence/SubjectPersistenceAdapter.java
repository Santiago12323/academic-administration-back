package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence;

import com.santiago.coronado.academic_administration.domain.model.Subject;
import com.santiago.coronado.academic_administration.domain.port.out.SubjectRepositoryPort;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper.SubjectPersistenceMapper;
import com.santiago.coronado.academic_administration.infrastructure.repository.JpaSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SubjectPersistenceAdapter implements SubjectRepositoryPort {

    private final JpaSubjectRepository repository;
    private final SubjectPersistenceMapper mapper;

    @Override
    public Subject save(Subject subject) {
        return mapper.toDomain(repository.save(mapper.toEntity(subject)));
    }

    @Override
    public Optional<Subject> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Subject> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDomain);
    }
}