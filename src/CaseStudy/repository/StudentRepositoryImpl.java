package CaseStudy.repository;

import CaseStudy.Model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {

    private static  List<Student> students;
    static {
        students = new ArrayList<>();
        students.add(new Student(1, "HV-001","Bùi Lê Nam", LocalDate.parse("2004-09-03"), "lenam@gmail.com", "C0324M4"));
        students.add(new Student(2, "HV-002", "Bùi Xuân Huấn", LocalDate.parse("1984-09-03"), "huanrose@gmail.com", "C0324M4"));
        students.add(new Student(3, "HV-003","Ngô Bá Khá", LocalDate.parse("1993-11-27"), "khabanh@gmail.com", "C0324M4"));
    }


    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public List<Student> searchStundent(Student student) {
        return students;
    }

    @Override
    public void writeToCSV() {

    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
       students.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public void editStudent(Student student) {
    }
}