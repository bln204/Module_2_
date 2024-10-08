package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> getStudentById(int id);
    void addNewStudent(Student student);
    void deleteStudent(int id);
    void save(Student student);
}
