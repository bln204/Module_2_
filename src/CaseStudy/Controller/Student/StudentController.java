package CaseStudy.Controller.Student;


import CaseStudy.Model.Student;
import CaseStudy.sevice.IStudentSevice;
import CaseStudy.sevice.StudentSeviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;


public class StudentController {

    private static Scanner scanner = new Scanner(System.in);
    private static final IStudentSevice iStudentSevice = new StudentSeviceImpl();

    public void displayStudents() {
        List<Student> studentList = iStudentSevice.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void addStudent() {
        System.out.println("Nhập số học viên cần thêm:");
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin học viên thứ " + (i + 1) + ":");
//            System.out.println("Nhập id học viên:");
//            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập mã học viên:");
            String code = scanner.nextLine();
            System.out.println("Nhập tên học viên");
            String name = scanner.nextLine();
            System.out.println("Nhập ngày sinh học viên:");
            LocalDate birthday = LocalDate.parse(scanner.nextLine());
            System.out.println("Nhập email học viên:");
            String email = scanner.nextLine();
            System.out.println("Nhập mã lớp học viên:");
            String className = scanner.nextLine();
            Student student = new Student(0, code, name, birthday, email, className);
            iStudentSevice.addStudent(student);
        }

        System.out.println("Đã thêm thành công học viên!");
        System.out.println();
    }

    public void removeStudent() {
        System.out.println("Nhập id học viên cần xóa:");
        int id = Integer.parseInt(scanner.nextLine());
        List<Student> students = iStudentSevice.findAll();

        for (Student temp : students) {
            if (temp.getId() == id) {
                System.out.println("Học viên có id " + id + " đã tồn tại. Bạn có muốn xóa? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    iStudentSevice.removeStudent(temp);
                    System.out.println("Đã xóa thành công học viên với id: " + id);
                    System.out.println();
                    return;
                } else {
                    System.out.println("Đã hủy xóa học viên với id: " + id);
                    System.out.println();
                    return;
                }
            }
        }

        System.out.println("Không tìm thấy học viên với id: " + id);
        System.out.println();
    }

    public void editStudent() {
        System.out.println("Nhập id học viên cần chỉnh sửa:");
        int id = Integer.parseInt(scanner.nextLine());
        List<Student> students = iStudentSevice.findAll();

        for (Student temp : students) {
            if (temp.getId() == id) {
                System.out.println("Học viên có id " + id + " đã tồn tại. Bạn có muốn chỉnh sửa? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {

                    System.out.println("Lựa chọn trường cần chỉnh sửa: \n" +
                            "1. Mã học viên. \n" +
                            "2. Tên học viên. \n" +
                            "3. Ngày sinh học viên. \n" +
                            "4. Email học viên. \n" +
                            "5. Mã lớp học viên. \n" +
                            "0. Thoát.\n"
                    );
                    System.out.println("Chọn thông tin cần chỉnh sửa: ");
                    int choiceEdit = Integer.parseInt(scanner.nextLine());
                    switch (choiceEdit) {
                        case 1:
                            System.out.println("Nhập mã học viên mới:");
                            String code = scanner.nextLine();
                            temp.setCode(code);
                            break;
                        case 2:
                            System.out.println("Nhập tên học viên mới:");
                            String name = scanner.nextLine();
                            temp.setName(name);
                            break;
                        case 3:
                            System.out.println("Nhập ngày sinh học viên mới:");
                            LocalDate birthday = LocalDate.parse(scanner.nextLine());
                            temp.setBirthday(birthday);
                            break;
                        case 4:
                            System.out.println("Nhập email học viên mới:");
                            String email = scanner.nextLine();
                            temp.setEmail(email);
                            break;
                        case 5:
                            System.out.println("Nhập mã lớp học viên mới:");
                            String className = scanner.nextLine();
                            temp.setClassName(className);
                            break;
                        case 0:
                            exit(0);
                            break;
                    }
                }
            }

        }

    }

    public void searchStudent(){
        System.out.println("Nhập tên học viên cần tìm: ");
        String temName = scanner.nextLine();
        List<Student> result = new ArrayList<>();
        List<Student> students = iStudentSevice.findAll();
        for (Student student : students){
            if (student.getName().contains(temName)){
                result.add(student);
            }
        }
        System.out.println(result);
    }
}
