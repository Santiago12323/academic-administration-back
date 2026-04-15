package com.santiago.coronado.academic_administration.infrastructure.repository;

import com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaStudentRepository extends JpaRepository<StudentEntity, String> {
    @Query("SELECT s FROM StudentEntity s LEFT JOIN FETCH s.grades WHERE s.id = :id")
    Optional<StudentEntity> findByIdWithGrades(String id);

    @Query("SELECT s FROM StudentEntity s WHERE " +
            "LOWER(s.firstName) LIKE LOWER(concat('%', :term, '%')) OR " +
            "LOWER(s.lastName) LIKE LOWER(concat('%', :term, '%')) OR " +
            "s.id LIKE concat('%', :term, '%')")
    Page<StudentEntity> findByTerm(String term, Pageable pageable);
}