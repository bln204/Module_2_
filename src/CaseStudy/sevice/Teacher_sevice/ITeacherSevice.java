package CaseStudy.sevice.Teacher_sevice;

import CaseStudy.Model.Teacher;

import java.util.List;

public interface ITeacherSevice {
    List<Teacher> findAll();
    void addTeacher(Teacher teacher);
    void removeTeacher(int id);
    void editTeacher(Teacher teacher);
    List<Teacher> searchTeacher(Teacher teacher);

    Teacher findByID(int id);
}
