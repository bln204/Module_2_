package CaseStudy.repository;

import CaseStudy.Model.Teacher;
import java.util.List;
public interface ITeacherRepository {
    List<Teacher> findAll();
    void addTeacher (Teacher teacher);
    void removeTeacher(Teacher teacher);
    void editTeacher(Teacher teacher);
}
