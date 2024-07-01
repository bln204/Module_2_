package CaseStudy.sevice;

import CaseStudy.Model.Teacher;
import CaseStudy.repository.ITeacherRepository;
import CaseStudy.repository.TeacherRepositoryImpl;

import java.util.List;

public class TeacherSeviceImpl implements ITeacherSevice{

    private ITeacherRepository iTeacherRepository = new TeacherRepositoryImpl();

    @Override
    public void addTeacher(Teacher teacher) {
        iTeacherRepository.addTeacher(teacher);
    }

    @Override
    public void removeTeacher(Teacher teacher) {
        iTeacherRepository.removeTeacher(teacher);
    }

    @Override
    public void editTeacher(Teacher teacher) {

    }

    @Override
    public List<Teacher> findAll() {
        return iTeacherRepository.findAll();
    }
}
