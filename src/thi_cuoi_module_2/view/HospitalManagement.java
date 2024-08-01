package thi_cuoi_module_2.view;

import CaseStudy.Controller.Student.StudentController;
import thi_cuoi_module_2.controller.regular_patient.RegularPatientController;
import thi_cuoi_module_2.controller.vip_patient.VipPatientController;

import java.util.Scanner;

public class HospitalManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        chooseMainFunction();
    }

    public static void chooseMainFunction() {
        do {
            System.out.println("Lựa chọn chức năng: \n" +
                    "1. Quản lý bệnh nhân thường. \n" +
                    "2. Quản lý bệnh nhân VIP. \n" +
                    "3. Kết thúc chương trình. \n"
            );
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    chooseRegularPatientFunction();
                    break;
                case 2:
                    ;
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

    public static void chooseRegularPatientFunction(){
        RegularPatientController patientController = new RegularPatientController();
        do{
            System.out.println("Lựa chọn chức năng: \n" +
                    "1. Hiển thị danh sách. \n" +
                    "2. Thêm mới bệnh nhân. \n" +
                    "3. Chỉnh sửa thông tin bệnh nhân. \n" +
                    "4. Xóa bệnh nhân. \n" +
                    "5. Thoát. "
            );
            int choiceStudent = Integer.parseInt(scanner.nextLine());
            switch (choiceStudent){
                case 1:
                    patientController.displayPatient();
                    break;
                case 2:
                    patientController.addPatient();
                    break;
                case 3:
                    patientController.update();
                    break;
                case 4:
                    patientController.delete();
                    break;
                case 5:
                    return;
            }

        }while (true);
    }

    public static void chooseVipPatientFunction(){
        VipPatientController vipPatientController = new VipPatientController();
        do{
            System.out.println("Lựa chọn chức năng: \n" +
                    "1. Hiển thị danh sách. \n" +
                    "2. Thêm mới bệnh nhân. \n" +
                    "3. Chỉnh sửa thông tin bệnh nhân. \n" +
                    "4. Xóa bệnh nhân. \n" +
                    "5. Thoát. "
            );
            int choiceStudent = Integer.parseInt(scanner.nextLine());
            switch (choiceStudent){
                case 1:
                    vipPatientController.displayPatient();
                    break;
                case 2:
                    vipPatientController.addPatient();
                    break;
                case 3:
                    vipPatientController.update();
                    break;
                case 4:
                    vipPatientController.delete();
                    break;
                case 5:
                    return;
            }
        } while(true);
    }
}

