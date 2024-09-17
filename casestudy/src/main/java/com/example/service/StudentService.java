package com.example.service;

import com.example.model.Student;
import com.example.repository.student_repository.IStudentRepository;
import com.example.repository.student_repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.addNewStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        iStudentRepository.deleteStudent(id);
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public List<Student> getStudentById(int id) {
        return iStudentRepository.getStudentById(id);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }
}
