package CaseStudy.sevice;

import CaseStudy.Model.Teacher;

import java.util.List;

public interface ITeacherSevice {
    List<Teacher> findAll();
    void addTeacher(Teacher teacher);
    void removeTeacher(Teacher teacher);
    void editTeacher(Teacher teacher);
    List<Teacher> searchTeacher(Teacher teacher);
}
