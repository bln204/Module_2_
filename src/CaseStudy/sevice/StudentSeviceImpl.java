package CaseStudy.sevice;

import CaseStudy.Model.Student;
import CaseStudy.repository.IStudentRepository;
import CaseStudy.repository.StudentRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class StudentSeviceImpl implements IStudentSevice{
    private final IStudentRepository iStudentRepository = new StudentRepositoryImpl();


    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        iStudentRepository.addStudent(student);
    }

    @Override
    public void removeStudent(Student student) {
        iStudentRepository.removeStudent(student);
    }

    @Override
    public void editStudent(Student student) {

    }
}
