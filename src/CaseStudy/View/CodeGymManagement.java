package CaseStudy.View;

import CaseStudy.Controller.Student.StudentController;
import CaseStudy.Controller.Teacher.TeacherController;
import CaseStudy.common.IOStreamStudent;

import java.util.Scanner;

public class CodeGymManagement {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        chooseMainFunction();
    }

    public static void chooseMainFunction() {
        do {
            System.out.println("Lựa chọn chức năng: \n" +
                    "1. Quản lý học viên. \n" +
                    "2. Quản lý giảng viên. \n" +
                    "3. Kết thúc chương trình. \n"
            );
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    chooseStudentFunction();
                    break;
                case 2:
                    chooseTeacherFunction();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void chooseStudentFunction(){

        StudentController studentController = new StudentController();
        do{
            System.out.println("Lựa chọn chức năng: \n" +
                    "1. Hiển thị danh sách. \n" +
                    "2. Thêm mới học viên. \n" +
                    "3. Chỉnh sửa thông tin học viên. \n" +
                    "4. Xóa học viên. \n" +
                    "5. Tìm kiếm học viên. \n" +
                    "6. Quay về. \n"
            );
            int choiceStudent = Integer.parseInt(scanner.nextLine());
            switch (choiceStudent){
                case 1:
                    studentController.displayStudents();
                    break;
                case 2:
                    studentController.addStudent();
                    break;
                case 3:
                    studentController.editStudent();
                    break;
                case 4:
                    studentController.removeStudent();
                    break;
                case 5:
                    studentController.searchStudent();
                    break;
                case 6:
                    return;
            }

        }while (true);
    }


    public static void chooseTeacherFunction(){
        TeacherController teacherController = new TeacherController();
        do{
            System.out.println("Lựa chọn chức năng: \n" +
                    "1. Hiển thị danh sách. \n" +
                    "2. Thêm mới giảng viên. \n" +
                    "3. Chỉnh sửa thông tin giảng viên. \n" +
                    "4. Xóa giảng viên. \n" +
                    "5. Tìm kiếm giảng viên. \n" +
                    "6. Quay về. \n"

            );
            int choiceTeacher = Integer.parseInt(scanner.nextLine());
            switch (choiceTeacher){
                case 1:
                    teacherController.displayTeachers();
                    break;
                case 2:
                    teacherController.addTeacher();
                    break;
                case 3:
                    teacherController.editTeacher();
                    break;
                case 4:
                    teacherController.removeTeacher();
                    break;
                case 5:
                    teacherController.searchTeacher();
                    break;
                case 6:
                    return;
            }
        }while (true);
    }
}
