package CaseStudy.Controller.Student;

import CaseStudy.Model.Student;
import CaseStudy.sevice.IStudentSevice;
import CaseStudy.sevice.StudentSeviceImpl;

public class StudentController {
    private IStudentSevice iStudentSevice = new StudentSeviceImpl();
    public void displayStudents (){
        Student[] students = iStudentSevice.findAll();
        for (Student student : students) {
            if( student == null){
                break;
            }
            System.out.println(student);
        }
    }
}
