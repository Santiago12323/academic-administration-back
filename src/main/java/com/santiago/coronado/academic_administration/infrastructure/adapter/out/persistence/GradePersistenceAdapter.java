package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence;

import com.santiago.coronado.academic_administration.domain.model.Grade;
import com.santiago.coronado.academic_administration.domain.port.out.GradeRepositoryPort;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.GradeEntity;
import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.mapper.GradePersistenceMapper;
import com.santiago.coronado.academic_administration.infrastructure.repository.JpaGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GradePersistenceAdapter implements GradeRepositoryPort {

    private final JpaGradeRepository jpaGradeRepository;
    private final GradePersistenceMapper gradeMapper;

    @Override
    public Grade save(Grade grade) {
        GradeEntity entity = gradeMapper.toEntity(grade);
        GradeEntity savedEntity = jpaGradeRepository.save(entity);
        return gradeMapper.toDomain(savedEntity);
    }

    @Override
    public List<Grade> findByStudentAndSubject(String studentId, String subjectId) {
        List<GradeEntity> entities = jpaGradeRepository.findByStudentIdAndSubjectId(studentId, subjectId);
        return gradeMapper.toDomainList(entities);
    }

    @Override
    public List<Grade> findByStudent(String studentId) {
        return jpaGradeRepository.findByStudentId(studentId)
                .stream()
                .map(gradeMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Grade> findById(String id) {
        return jpaGradeRepository.findById(id)
                .map(gradeMapper::toDomain);
    }

    @Override
    public void deleteById(String id) {
        jpaGradeRepository.deleteById(id);
    }
}