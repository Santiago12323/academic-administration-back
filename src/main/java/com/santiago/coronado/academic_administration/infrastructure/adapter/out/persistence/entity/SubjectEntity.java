package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "subjects")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String name;
    private String code;
    private Integer credits;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<GradeEntity> grades;
}