package CaseStudy.sevice;

import CaseStudy.Model.Teacher;
import CaseStudy.repository.ITeacherRepository;
import CaseStudy.repository.TeacherRepositoryImpl;

import java.util.List;

public class TeacherSeviceImpl implements ITeacherSevice{

    private ITeacherRepository iTeacherRepository = new TeacherRepositoryImpl();

    @Override
    public void addTeacher(Teacher teacher) {
        List<Teacher> list = findAll();
        int id;
        if(list.isEmpty()) {
            id = 1;
            teacher.setId(id);
        } else {
            id = list.get(list.size() - 1).getId() + 1;
            teacher.setId(id);
        }
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
