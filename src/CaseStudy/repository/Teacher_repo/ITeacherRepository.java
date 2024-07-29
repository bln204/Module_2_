package CaseStudy.repository.Teacher_repo;

import CaseStudy.Model.Teacher;
import java.util.List;
public interface ITeacherRepository {
    List<Teacher> findAll();
    void addTeacher (Teacher teacher);
    void removeTeacher(int id);
    void editTeacher(Teacher teacher);
    List<Teacher> searchTeacher(Teacher teacher);
    Teacher findById(int id);
}
