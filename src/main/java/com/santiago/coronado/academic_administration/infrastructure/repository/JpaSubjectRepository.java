package com.santiago.coronado.academic_administration.infrastructure.repository;

import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSubjectRepository extends JpaRepository<SubjectEntity, String> {
}