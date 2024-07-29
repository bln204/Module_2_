package CaseStudy.repository.Student_repo;

import CaseStudy.Model.Student;
import CaseStudy.common.IOStreamStudent;


import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {

    private static  List<Student> students;
    static {
        students = new ArrayList<>();
//        students.add(new Student(1, "HV-001","Bùi Lê Nam", LocalDate.parse("2004-09-03"), "lenam@gmail.com", "C0324M4"));
//        students.add(new Student(2, "HV-002", "Bùi Xuân Huấn", LocalDate.parse("1984-09-03"), "huanrose@gmail.com", "C0324M4"));
//        students.add(new Student(3, "HV-003","Ngô Bá Khá", LocalDate.parse("1993-11-27"), "khabanh@gmail.com", "C0324M4"));
    }


    @Override
    public List<Student> findAll() {
        return IOStreamStudent.convertToListStudent();
    }


    @Override
    public List<Student> searchStudent(Student student) {
        List<Student> list = IOStreamStudent.convertToListStudent();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(student.getName())) {
                return List.of(list.get(i));
            }
        }
        return null;
    }

    @Override
    public Student findByID(int id) {
        List<Student> list = IOStreamStudent.convertToListStudent();
        for(Student s : list) {
            if(s.getId() == id) {
                return s;
            }
        }
        return null;
    }


    @Override
    public void addStudent(Student student) {
       IOStreamStudent.addStudentToFile(student);
    }

    @Override
    public void removeStudent(int id) {
        List<Student> list = IOStreamStudent.convertToListStudent();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        IOStreamStudent.importStudentToFile(list);
    }

    @Override
    public void editStudent(Student student) {
        List<Student> list = IOStreamStudent.convertToListStudent();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == student.getId()) {
                list.set(i, student);
                break;
            }
        }
        IOStreamStudent.importStudentToFile(list);
    }
}