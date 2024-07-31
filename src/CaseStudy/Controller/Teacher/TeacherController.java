package CaseStudy.Controller.Teacher;

import CaseStudy.Model.Student;
import CaseStudy.Model.Teacher;
import CaseStudy.sevice.Teacher_sevice.ITeacherSevice;
import CaseStudy.sevice.Teacher_sevice.TeacherSeviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class TeacherController {
    private static Scanner scanner = new Scanner(System.in);
    private ITeacherSevice iTeacherSevice = new TeacherSeviceImpl();

    public void displayTeachers() {
        List<Teacher> teachers = iTeacherSevice.findAll();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void addTeacher() {
        System.out.println("Nhập số lượng giảng viên cần thêm:");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin giảng viên thứ " + (i + 1) + ":");
            System.out.println("Nhập mã giảng viên có dạng GV-XXX:");
            String codeTemp = scanner.nextLine();
            String code = regexCode(codeTemp);
            System.out.println("Nhập tên giảng viên");
            String nameTemp = scanner.nextLine();
            String name = regexName(nameTemp);
            System.out.println("Nhập ngày sinh giảng viên dạng yyyy-MM-dd: ");
            String birthdayTemp = scanner.nextLine();
            LocalDate birthday = regexBirthday(birthdayTemp);
            System.out.println("Nhập email giảng viên:");
            String emailTemp =  scanner.nextLine();
            String email = regexEmail(emailTemp);
            System.out.println("Nhập mức lương:");
            String salaryTemp = scanner.nextLine();
            int salary = regexSalary(salaryTemp);
            Teacher teacher = new Teacher(0, code, name, birthday, email, salary);
            iTeacherSevice.addTeacher(teacher);
        }
        System.out.println("Đã thêm thành công!");
        System.out.println();
    }

    public void removeTeacher() {
        System.out.println("Nhập id giảng viên cần xóa:");
        int idRemove = Integer.parseInt(scanner.nextLine());
        if (isExist(idRemove)) {
            iTeacherSevice.removeTeacher(idRemove);
            System.out.println("Đã xóa thành công giảng viên với id: " + idRemove);
        } else {
            System.out.println("Giảng viên không tồn tại với id: " + idRemove);
        }
    }

    public void editTeacher() {
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
                            System.out.println("Nhập mã giảng viên mới dạng GV-XXX:");
                            String codeTemp = scanner.nextLine();
                            String code = regexCode(codeTemp);
                            temp.setCode(code);
                            break;
                        case 2:
                            System.out.println("Nhập tên giảng viên mới:");
                            String nameTemp = scanner.nextLine();
                            String name = regexName(nameTemp);
                            temp.setName(name);
                            break;
                        case 3:
                            System.out.println("Nhập ngày sinh giảng viên mới dạng yyyy-MM-dd:");
                            String birthdayTemp = scanner.nextLine();
                            LocalDate birthday = regexBirthday(birthdayTemp);
                            temp.setBirthday(birthday);
                            break;
                        case 4:
                            System.out.println("Nhập email giảng viên mới:");
                            String emailTemp =  scanner.nextLine();
                            String email = regexEmail(emailTemp);
                            temp.setEmail(email);
                            break;
                        case 5:
                            System.out.println("Nhập lương giảng viên mới:");
                            String salaryTemp = scanner.nextLine();
                            int salary = regexSalary(salaryTemp);
                            temp.setSalary(salary);
                            break;
                        case 0:
                            exit(0);
                            break;
                    }
                    iTeacherSevice.editTeacher(temp);
                    System.out.println("Đã cập nhật thành công!");
                }
            }

        }

    }

    public void searchTeacher() {
        System.out.println("Nhập tên giảng viên cần tìm:");
        String tempName = scanner.nextLine();
        List<Teacher> teachers = iTeacherSevice.findAll();
        List<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(tempName)) {
                result.add(teacher);
            }
        }
        System.out.println(result);
    }

    public boolean isExist(int id) {
        Teacher teacher = iTeacherSevice.findByID(id);
        return teacher != null;
    }

    public static String regexCode(String codeInput) {
        String codeRegex = "GV-\\d{3}";
        Pattern pat = Pattern.compile(codeRegex);
        Matcher matcher = pat.matcher(codeInput);

        if (matcher.matches()) {
            return codeInput;
        } else {
            while (true) {
                System.out.println("Mã giảng viên phải có dạng GV-XXX với XXX là số 3 chữ số. Vui lòng nhập lại:");
                codeInput = scanner.nextLine();
                matcher = pat.matcher(codeInput);
                if (matcher.matches()) {
                    return codeInput;
                }
            }
        }
    }

    public static String regexName(String nameInput) {
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern pat = Pattern.compile(nameRegex);
        Matcher matcher = pat.matcher(nameInput);

        if (matcher.matches()) {
            return nameInput;
        } else {
            while (true) {
                System.out.println("Tên chỉ được chứa các chữ cái và khoảng trắng. Vui lòng nhập lại:");
                nameInput = scanner.nextLine();
                matcher = pat.matcher(nameInput);
                if (matcher.matches()) {
                    return nameInput;
                }
            }
        }
    }

    public static LocalDate regexBirthday(String birthdayInput) {
        String birthdayRegex  = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        Pattern pat = Pattern.compile(birthdayRegex);
        Matcher matcher = pat.matcher(birthdayInput);

        if (matcher.matches()){
            return LocalDate.parse(birthdayInput);
        } else {
            while (true){
                System.out.println("Ngày sinh phải có dạng yyyy-MM-dd. Vui lòng nhập lại:");
                birthdayInput = scanner.nextLine();
                matcher = pat.matcher(birthdayInput);
                if (matcher.matches()) {
                    return LocalDate.parse(birthdayInput);
                }
            }
        }
    }

    public static String regexEmail(String emailInput) {
        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pat = Pattern.compile(emailRegex);
        Matcher matcher = pat.matcher(emailInput);

        if (matcher.matches()){
            return emailInput;
        } else {
            while (true){
                System.out.println("Email phải có dạng tài khoản email và phải đúng định dạng. Vui lòng nhập lại:");
                emailInput = scanner.nextLine();
                matcher = pat.matcher(emailInput);
                if (matcher.matches()) {
                    return emailInput;
                }
            }
        }
    }

    public static int regexSalary(String integerInput) {
        String integerRegex = "^\\d+$";
        Pattern pat = Pattern.compile(integerRegex);
        Matcher matcher = pat.matcher(integerInput);

        if (matcher.matches()) {
            return Integer.parseInt(integerInput);
        } else {
            while (true) {
                System.out.println("Chuỗi phải là số nguyên. Vui lòng nhập lại:");
                integerInput = scanner.nextLine();
                matcher = pat.matcher(integerInput);
                if (matcher.matches()) {
                    return Integer.parseInt(integerInput);
                }
            }
        }
    }
}



