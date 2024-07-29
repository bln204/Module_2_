package CaseStudy.sevice.Student_sevice;

import CaseStudy.Model.Student;
import CaseStudy.repository.Student_repo.IStudentRepository;
import CaseStudy.repository.Student_repo.StudentRepositoryImpl;

import java.util.List;

public class StudentSeviceImpl implements IStudentSevice {
    private final IStudentRepository iStudentRepository = new StudentRepositoryImpl();


    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public List<Student> searchStudent(Student student) {
        return iStudentRepository.searchStudent(student);
    }


    @Override
    public Student findByID(int id) {
        return iStudentRepository.findByID(id);
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
    public void removeStudent(int id) {
        iStudentRepository.removeStudent(id);
    }

    @Override
    public void editStudent(Student student) {
        iStudentRepository.editStudent(student);
    }
}
