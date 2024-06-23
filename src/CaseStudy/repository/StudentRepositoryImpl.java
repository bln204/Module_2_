package CaseStudy.repository;

import CaseStudy.Model.Student;

import java.time.LocalDate;

public class StudentRepositoryImpl implements IStudentRepository {

    private  static Student[] students;
    static {
        students = new Student[5];
        students[0] = new Student(1,"Bùi Lê Nam", LocalDate.parse("2004-09-03"),"lenam@gmail.com","C0324M4");
        students[1] = new Student(2,"Bùi Xuân Huấn", LocalDate.parse("1984-09-03"),"huanrose@gmail.com","C0324M4");
        students[2] = new Student(3,"Ngô Bá Khá", LocalDate.parse("1993-11-27"),"khabanh@gmail.com","C0324M4");
    }

    @Override
    public Student[] findAll() {
        return students;
    }
}
