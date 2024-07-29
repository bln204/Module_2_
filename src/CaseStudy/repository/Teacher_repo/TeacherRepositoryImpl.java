package CaseStudy.repository.Teacher_repo;

import CaseStudy.Model.Student;
import CaseStudy.Model.Teacher;
import CaseStudy.common.IOStreamStudent;
import CaseStudy.common.IOStreamTeacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImpl implements ITeacherRepository {
    private static List<Teacher> teachers;

    static {
        teachers = new ArrayList<>();
//        teachers.add(new Teacher(1,"GV-001","Nguyễn Thành Công", LocalDate.parse("1991-09-10"),"congnguyen@gmail.com",5000000));
//        teachers.add(new Teacher(2,"GV-002","Phan Vũ Luân", LocalDate.parse("1996-10-05"),"luanphan@gmail.com",5000000));
    }

    @Override
    public List<Teacher> findAll() {
        return IOStreamTeacher.convertToListStudent();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        IOStreamTeacher.addTeacherToFile(teacher);
    }

    @Override
    public void removeTeacher(int id) {
        List<Teacher> list = IOStreamTeacher.convertToListStudent();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        IOStreamTeacher.importTeacherToFile(list);
    }

    @Override
    public void editTeacher(Teacher teacher) {
        List<Teacher> list = IOStreamTeacher.convertToListStudent();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == teacher.getId()) {
                list.set(i, teacher);
                break;
            }
        }
        IOStreamTeacher.importTeacherToFile(list);
    }

    @Override
    public List<Teacher> searchTeacher(Teacher teacher) {
        List<Teacher> list = IOStreamTeacher.convertToListStudent();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(teacher.getName())) {
                return List.of(list.get(i));
            }
        }
        return null;
    }

    @Override
    public Teacher findById(int id) {
        List<Teacher> list = IOStreamTeacher.convertToListStudent();
        for(Teacher t : list) {
            if(t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}



