package CaseStudy.sevice;

import CaseStudy.Model.Student;
import CaseStudy.repository.IStudentRepository;
import CaseStudy.repository.StudentRepositoryImpl;

public class StudentSeviceImpl implements IStudentSevice{

    private IStudentRepository iStudentRepository = new StudentRepositoryImpl();

    @Override
    public Student[] findAll() {
        return iStudentRepository.findAll();
    }



    @Override
    public Student[] addStudent() {
        iStudentRepository.addStudent();
        return null;
    }
}
