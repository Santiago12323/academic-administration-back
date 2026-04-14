package com.santiago.coronado.academic_administration.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<GradeEntity> grades;
}
