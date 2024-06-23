package CaseStudy.sevice;

import CaseStudy.Model.Teacher;
import CaseStudy.repository.ITeacherRepository;
import CaseStudy.repository.ITeacherRepositoryImpl;

public class TeacherSeviceImpl implements ITeacherSevice{

    private ITeacherRepository iTeacherRepository = new ITeacherRepositoryImpl();

    @Override
    public Teacher[] findAll() {
        return iTeacherRepository.findAll();
    }
}
