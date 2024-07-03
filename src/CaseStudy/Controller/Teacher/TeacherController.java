package CaseStudy.Controller.Teacher;

import CaseStudy.Model.Student;
import CaseStudy.Model.Teacher;
import CaseStudy.sevice.ITeacherSevice;
import CaseStudy.sevice.TeacherSeviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class TeacherController {
    private static Scanner scanner = new Scanner(System.in);
    private ITeacherSevice iTeacherSevice = new TeacherSeviceImpl();
    public void displayTeachers (){
        List<Teacher> teachers = iTeacherSevice.findAll();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void addTeacher (){
        System.out.println("Nhập số lượng giảng viên cần thêm:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin giảng viên thứ " + (i + 1) + ":");
//            System.out.println("Nhập id giảng viên:");
//            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập mã giảng viên:");
            String code = scanner.nextLine();
            System.out.println("Nhập tên giảng viên:");
            String name = scanner.nextLine();
            System.out.println("Nhập ngày sinh:");
            LocalDate birthday = LocalDate.parse(scanner.nextLine());
            System.out.println("Nhập email:");
            String email = scanner.nextLine();
            System.out.println("Nhập mức lương:");
            int salary = Integer.parseInt(scanner.nextLine());
            Teacher teacher = new Teacher(0, code, name, birthday, email, salary);
            iTeacherSevice.addTeacher(teacher);
        }
        System.out.println("Đã thêm thành công!");
        System.out.println();
    }

    public void removeTeacher (){
        System.out.println("Nhập id giảng viên cần xóa:");
        int id = Integer.parseInt(scanner.nextLine());
        List<Teacher> students = iTeacherSevice.findAll();

        for (Teacher temp : students) {
            if (temp.getId() == id) {
                System.out.println("Giảng viên có id " + id + " đã tồn tại. Bạn có muốn xóa? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    iTeacherSevice.removeTeacher(temp);
                    System.out.println("Đã xóa thành công giảng viên với id: " + id);
                    System.out.println();
                    return;
                } else {
                    System.out.println("Đã hủy xóa giảng viên với id: " + id);
                    System.out.println();
                    return;
                }
            }
        }

        System.out.println("Không tìm thấy giảng viên với id: " + id);
        System.out.println();
    }

    public void editTeacher (){
        System.out.println("Nhập id giảng viên cần chỉnh sửa:");
        int id = Integer.parseInt(scanner.nextLine());
        List<Teacher> teachers = iTeacherSevice.findAll();

        for (Teacher temp : teachers) {
            if (temp.getId() == id) {
                System.out.println("Giảng viên có id " + id + " đã tồn tại. Bạn có muốn chỉnh sửa? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {

                    System.out.println("Lựa chọn trường cần chỉnh sửa: \n" +
                            "1. Mã giảng viên. \n" +
                            "2. Tên giảng viên. \n" +
                            "3. Ngày sinh giảng viên. \n" +
                            "4. Email giảng viên. \n" +
                            "5. Lương giảng viên. \n" +
                            "0. Thoát.\n"
                    );
                    System.out.println("Chọn thông tin cần chỉnh sửa: ");
                    int choiceEdit = Integer.parseInt(scanner.nextLine());
                    switch (choiceEdit) {
                        case 1:
                            System.out.println("Nhập mã giảng viên mới:");
                            String code = scanner.nextLine();
                            temp.setCode(code);
                            break;
                        case 2:
                            System.out.println("Nhập tên giảng viên mới:");
                            String name = scanner.nextLine();
                            temp.setName(name);
                            break;
                        case 3:
                            System.out.println("Nhập ngày sinh giảng viên mới:");
                            LocalDate birthday = LocalDate.parse(scanner.nextLine());
                            temp.setBirthday(birthday);
                            break;
                        case 4:
                            System.out.println("Nhập email giảng viên mới:");
                            String email = scanner.nextLine();
                            temp.setEmail(email);
                            break;
                        case 5:
                            System.out.println("Nhập lương giảng viên mới:");
                            int salary = scanner.nextInt();
                            temp.setSalary(salary);
                            break;
                        case 0:
                            exit(0);
                            break;
                    }
                }
            }

        }

    }
}
