package com.example.repository.student_repository;

import com.example.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<Student> getStudentById(int id);
    void save(Student student);
    void addNewStudent(Student student);
    void deleteStudent(int id);
}
