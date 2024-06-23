package CaseStudy.sevice;

import CaseStudy.Model.Student;

public interface IStudentSevice {
    Student[] findAll();
    Student[] addStudent();
}
