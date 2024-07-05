package CaseStudy.repository;

import CaseStudy.Model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void addStudent(Student student);
    void removeStudent(Student student);
    void editStudent(Student student);
    List<Student> searchStundent(Student student);
}
