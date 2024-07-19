package CaseStudy.sevice;

import CaseStudy.Model.Student;

import java.util.List;

public interface IStudentSevice {
    List<Student> findAll();
    void addStudent(Student student);
    void removeStudent(Student student);
    void editStudent(Student student);
    List<Student> searchStudent(Student student);
    void writeToCSV ();
    List<Student> getStudents();
}
