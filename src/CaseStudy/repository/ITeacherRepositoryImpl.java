package CaseStudy.repository;

import CaseStudy.Model.Teacher;

import java.time.LocalDate;

public class ITeacherRepositoryImpl implements ITeacherRepository{
    private static Teacher[] teachers;
    static{
        teachers = new Teacher[5];
        teachers[0] = new Teacher(1,"Nguyễn Thành Công", LocalDate.parse("1991-09-10"),"congnguyen@gmail.com",5000000);
        teachers[1] = new Teacher(2,"Phan Vũ Luân",LocalDate.parse("1996-10-05"),"luanphan@gmail.com",5000000);
    }

    @Override
    public Teacher[] findAll() {
        return teachers;
    }
}
