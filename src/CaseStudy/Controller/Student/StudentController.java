package CaseStudy.Controller.Student;

import CaseStudy.Model.Student;
import CaseStudy.sevice.IStudentSevice;
import CaseStudy.sevice.StudentSeviceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
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

    public void addStudent(){
        System.out.println("Nhập số học viên cần thêm:");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin học viên thứ " + (i + 1) + ":");
            System.out.println("Nhập id học viên:");
            int id = scanner.nextInt();
            System.out.println("Nhập tên học viên");
            String name = scanner.nextLine();
            System.out.println("Nhập ngày sinh học viên:");
            LocalDate birthday = LocalDate.parse(scanner.nextLine());
            System.out.println("Nhập email học viên:");
            String email = scanner.nextLine();
            System.out.println("Nhập mã lớp học viên:");
            String className = scanner.nextLine();

            Student[] students = iStudentSevice.addStudent();
        }
    }
}
