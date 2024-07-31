package CaseStudy.sevice.Teacher_sevice;

import CaseStudy.Model.Teacher;
import CaseStudy.common.IOStreamTeacher;
import CaseStudy.repository.Teacher_repo.ITeacherRepository;
import CaseStudy.repository.Teacher_repo.TeacherRepositoryImpl;

import java.util.List;

public class TeacherSeviceImpl implements ITeacherSevice {

    private ITeacherRepository iTeacherRepository = new TeacherRepositoryImpl();

    @Override
    public List<Teacher> searchTeacher(Teacher teacher) {
        return List.of();
    }

    @Override
    public Teacher findByID(int id) {
        return iTeacherRepository.findById(id);
    }

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
    public void removeTeacher(int id) {
        iTeacherRepository.removeTeacher(id);
    }

    @Override
    public void editTeacher(Teacher teacher) {
        iTeacherRepository.editTeacher(teacher);

    }

    @Override
    public List<Teacher> findAll() {
        return IOStreamTeacher.convertToListStudent();
    }
}
