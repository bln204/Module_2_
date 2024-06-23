package CaseStudy.repository;

import CaseStudy.Model.Student;
public interface IStudentRepository {
    Student[] findAll();
    Student[] addStudent();
}
