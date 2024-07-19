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
    public List<Student> searchStudent(Student student) {
        return List.of();
    }

    @Override
    public void writeToCSV() {

    }

    @Override
    public List<Student> getStudents() {
        return iStudentRepository.getStudents();
    }

    @Override
    public void addStudent(Student student) {
        List<Student> list = findAll();
        int id;
        if(list.isEmpty()) {
            id = 1;
            student.setId(id);
        } else {
            id = list.get(list.size() - 1).getId() + 1;
            student.setId(id);
        }
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
