package CaseStudy.Controller.Student;


import CaseStudy.Model.Student;
import CaseStudy.sevice.Student_sevice.IStudentSevice;
import CaseStudy.sevice.Student_sevice.StudentSeviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.println("Nhập mã học viên có dạng HV-XXX:");
            String codeTemp = scanner.nextLine();
            String code = regexCode(codeTemp);
            System.out.println("Nhập tên học viên");
            String name = scanner.nextLine();
            System.out.println("Nhập ngày sinh học viên dạng dd-MM-yyyy: ");
//            String birthdayTemp = scanner.nextLine();
//            LocalDate birthday = regexBirthday(birthdayTemp);
            LocalDate birthday = LocalDate.parse(scanner.nextLine());
            System.out.println("Nhập email học viên:");
//            String emailTemp =  scanner.nextLine();
//            String email = regexEmail(emailTemp);
            String email = scanner.nextLine();
            System.out.println("Nhập mã lớp học viên: ");
//            String classNameTemp = scanner.nextLine();
//            String className = regexClassName(classNameTemp);
            String className = scanner.nextLine();
            Student student = new Student(0, code, name, birthday, email, className);
            iStudentSevice.addStudent(student);
        }

        System.out.println("Đã thêm thành công học viên!");
        System.out.println();
    }

    public boolean isExist(int id){
        Student student = iStudentSevice.findByID(id);
        return student!= null;
    }

    public static String regexCode(String codeInput) {
        String codeRegex = "HV-\\d{3}";
        Pattern pat = Pattern.compile(codeRegex);
        Matcher matcher = pat.matcher(codeInput);

            if (matcher.matches()) {
                return codeInput;
            } else {
                while (true) {
                    System.out.println("Mã học viên phải có dạng HV-XXX với XXX là số 3 chữ số. Vui lòng nhập lại:");
                    System.out.println("Nhập lại mã học viên:");
                    codeInput = scanner.nextLine();
                    pat.matcher(codeInput);
            }
        }
    }

    public static LocalDate regexBirthday (String birthdayInput){
        String birthdayRegex  = "^([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$";
        Pattern pat = Pattern.compile(birthdayRegex);
        Matcher matcher = pat.matcher(birthdayInput);

            if (matcher.matches()){
                LocalDate birthday = LocalDate.parse(birthdayInput, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                return birthday;
            } else {
                while (true){
                    System.out.println("Ngày sinh phải có dạng dd-MM-yyyy. Vui lòng nhập lại:");
                    System.out.println("Nhập lại ngày sinh học viên (dd-MM-yyyy):");
                    birthdayInput = scanner.nextLine();
                    pat.matcher(birthdayInput);
            }
        }
    }

    public static String regexEmail(String emailInput) {
        String emailRegex = "\\\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\\\b ";
        Pattern pat = Pattern.compile(emailRegex);
        Matcher matcher = pat.matcher(emailInput);

            if (matcher.matches()){
                return emailInput;
            } else {
                while (true){
                    System.out.println("Email phải có dạng tài khoản email và phải đúng định dạng. Vui lòng nhập lại:");
                    System.out.println("Nhập lại email học viên:");
                    String email = scanner.nextLine();
                    pat.matcher(email);
            }
        }
    }

    public static String regexClassName(String classNameInput){
        String classNameRegex = "^C\\\\w{6}$";
        Pattern pat = Pattern.compile(classNameRegex);
        Matcher matcher = pat.matcher(classNameInput);
            if (matcher.matches()){
                return classNameInput;
            } else {
                while (true){ System.out.println("Mã lớp học viên phải có dạng C-XXXXXX. Vui lòng nhập lại:");
                System.out.println("Nhập mã lớp học viên:");
                String className = scanner.nextLine();
                matcher = pat.matcher(className);
            }
        }
    }

    public void removeStudent() {
        System.out.println("Nhập id học viên cần xóa:");
        int idRemove = Integer.parseInt(scanner.nextLine());
        if(isExist(idRemove)){
            iStudentSevice.removeStudent(idRemove);
            System.out.println("Đã xóa thành công học viên với id: " + idRemove);
        } else{
            System.out.println("Học viên không tồn tại với id: " + idRemove);
        }
    }

    public void editStudent() {
        System.out.println("Nhập id học viên cần chỉnh sửa:");
        int  idEdit = Integer.parseInt(scanner.nextLine());
        List<Student> students = iStudentSevice.findAll();
        if(isExist( idEdit)){
            for (Student temp : students) {
                if (temp.getId() ==  idEdit) {
                    System.out.println("Học viên có id " +  idEdit + " đã tồn tại. Bạn có muốn chỉnh sửa? (y/n)");
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
                        iStudentSevice.editStudent(temp);
                        System.out.println("Đã cập nhật thành công!");
                    }
                }

            }
        } else{
            System.out.println("ID "+  idEdit + " không tồn tại!");
        }
    }

    public void searchStudent() {
        System.out.println("Nhập tên học viên cần tìm: ");
        String temName = scanner.nextLine();
        List<Student> result = new ArrayList<>();
        List<Student> students = iStudentSevice.findAll();
        for (Student student : students) {
            if (student.getName().contains(temName)) {
                result.add(student);
            }
        }
        System.out.println(result);
    }


}
