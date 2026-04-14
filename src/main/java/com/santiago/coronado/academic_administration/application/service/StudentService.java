package com.santiago.coronado.academic_administration.application.service;

import com.santiago.coronado.academic_administration.application.usecase.StudentUseCase;
import com.santiago.coronado.academic_administration.domain.exception.BusinessRuleException;
import com.santiago.coronado.academic_administration.domain.model.Student;
import com.santiago.coronado.academic_administration.domain.port.out.StudentRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    @Override
    public Student createStudent(Student student) {
        return studentRepositoryPort.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepositoryPort.findById(id)
                .orElseThrow(() -> new BusinessRuleException("Business Rule Violation: Student not found with ID: " + id));
    }

    @Override
    public Page<Student> getAllStudents(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return studentRepositoryPort.findAll(pageable);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepositoryPort.deleteById(id);
    }


    @Override
    public Student updateStudent(String id, Student studentUpdate) {
        return studentRepositoryPort.findById(id)
                .map(existingStudent -> {
                    Student updatedStudent = Student.builder()
                            .id(id)
                            .firstName(studentUpdate.getFirstName())
                            .lastName(studentUpdate.getLastName())
                            .email(studentUpdate.getEmail())
                            .birthDate(studentUpdate.getBirthDate())
                            .grades(existingStudent.getGrades())
                            .build();

                    return studentRepositoryPort.save(updatedStudent);
                })
                .orElseThrow(() -> new BusinessRuleException("Business Rule Violation: Student not found with ID: " + id));
    }
}