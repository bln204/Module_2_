package CaseStudy.Controller.Teacher;

import CaseStudy.Model.Teacher;
import CaseStudy.sevice.ITeacherSevice;
import CaseStudy.sevice.TeacherSeviceImpl;

public class TeacherController {
    private ITeacherSevice iTeacherSevice = new TeacherSeviceImpl();
    public void displayTeachers (){
        Teacher[] teachers = iTeacherSevice.findAll();
        for (Teacher teacher : teachers) {
            if( teacher == null){
                break;
            }
            System.out.println(teacher);
        }
    }
}
