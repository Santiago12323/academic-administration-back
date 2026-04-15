package com.santiago.coronado.academic_administration.application.usecase;

import com.santiago.coronado.academic_administration.domain.model.Student;
import org.springframework.data.domain.Page;

public interface StudentUseCase {
    Student createStudent(Student student);

    Page<Student> getAllStudents(int page, String searchTerm);

    Student getStudentById(String id);

    Page<Student> getAllStudents(int page);

    void deleteStudent(String id);

    Student updateStudent(String id, Student studentUpdate);
}
