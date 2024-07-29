package CaseStudy.repository.Student_repo;

import CaseStudy.Model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void addStudent(Student student);

    void removeStudent(int id);

    void editStudent(Student student);

    List<Student> searchStudent(Student student);

    Student findByID(int id);

}