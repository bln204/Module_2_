package CaseStudy.repository;

import CaseStudy.Model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImpl implements ITeacherRepository{
    private static List<Teacher> teachers;
    static{
        teachers = new ArrayList<>();
        teachers.add(new Teacher(1,"GV-001","Nguyễn Thành Công", LocalDate.parse("1991-09-10"),"congnguyen@gmail.com",5000000));
        teachers.add(new Teacher(2,"GV-002","Phan Vũ Luân", LocalDate.parse("1996-10-05"),"luanphan@gmail.com",5000000));
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    @Override
    public void editTeacher(Teacher teacher) {

    }

    @Override
    public List<Teacher> findAll() {
        return teachers;
    }
}
