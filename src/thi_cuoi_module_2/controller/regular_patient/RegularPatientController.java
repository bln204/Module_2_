package thi_cuoi_module_2.controller.regular_patient;

import thi_cuoi_module_2.model.RegularPatient;
import thi_cuoi_module_2.model.VIPPatient;
import thi_cuoi_module_2.sevice.regular_patient.IRegularPatientService;
import thi_cuoi_module_2.sevice.regular_patient.RegularPatientService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class RegularPatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static IRegularPatientService regularPatientService = new RegularPatientService();

    public void displayPatient() {
        List<RegularPatient> patientList = regularPatientService.display();
        for (RegularPatient patient : patientList) {
            System.out.println(patient);
        }
    }

    public void addPatient() {
        System.out.println("Nhập số bệnh nhân thường cần thêm: ");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin bệnh nhân thường thứ " + (i + 1) + ":");
            LocalDate admissionDate = null;
            while (admissionDate == null) {
                System.out.println("Nhập ngày nhập viện (dd-MM-yyyy):");
                try {
                    admissionDate = LocalDate.parse(scanner.nextLine());
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày nhập viện không hợp lệ, vui lòng nhập lại.");
                }
            }
            System.out.println("Nhập lý do đến khám:");
            String reason = scanner.nextLine();
            System.out.println("Nhập tên bệnh nhân:");
            String name = scanner.nextLine();
            System.out.println("Nhập số thứ tự bệnh nhân:");
            int id = Integer.parseInt(scanner.nextLine());
            LocalDate dischargeDate = null;
            while (dischargeDate == null) {
                System.out.println("Nhập ngày xuất viện (dd-MM-yyyy):");
                try {
                    dischargeDate = LocalDate.parse(scanner.nextLine());
                    if (dischargeDate.isBefore(admissionDate)) {
                        System.out.println("Ngày xuất viện phải sau ngày nhập viện, vui lòng nhập lại.");
                        dischargeDate = null;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày xuất viện không hợp lệ, vui lòng nhập lại.");
                }
            }
            System.out.println("Nhập mã bệnh án:");
            String code = scanner.nextLine();
            System.out.println("Nhập viện phí");
            int hospital_stay_fee = scanner.nextInt();
            RegularPatient regularPatient = new RegularPatient(admissionDate, reason, name, id, dischargeDate, code, hospital_stay_fee);
        }
        System.out.println("Thêm thành công bệnh nhân!");
        System.out.println();
    }

    public boolean isExit(int id) {
        RegularPatient patient = regularPatientService.findById(id);
        return patient != null;
    }
    public void delete() {
        System.out.println("Nhập số thứ tự bệnh nhân cần xóa:");
        int idDelete = Integer.parseInt(scanner.nextLine());
        if (isExit(idDelete)) {
            regularPatientService.delete(idDelete);
            System.out.println("Đã xóa thành công bệnh nhân với số thứ tự " + idDelete + "!");
        } else {
            System.out.println("Không tìm thấy bệnh nhân với số thứ tự " + idDelete + "!");
        }
        System.out.println();
    }

    public void update() {
        System.out.println("Nhập số thứ tự bệnh nhân cần cập nhật:");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        List<RegularPatient> regularPatients = new ArrayList<>();

        if (isExit(idUpdate)) {
            for(RegularPatient patient : regularPatients) {
                if(patient.getId() == idUpdate) {
                    System.out.println("Bệnh nhân có số thứ tự là " + idUpdate + " đã tồn tại bạn có muốn chỉnh sửa? (y/n)");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("y")){
                        System.out.println("Lựa chọn trường cần chỉnh sửa: \n" +
                                "1. Tên bệnh nhân. \n" +
                                "2. Ngày nhập viện. \n" +
                                "3. Lý do đến khám. \n" +
                                "4. Số thứ tự bệnh nhân. \n" +
                                "5. Ngày xuất viện. \n" +
                                "6. Mã bệnh án. \n" +
                                "7. Phí viện phí. \n" +
                                "0. Thoát.\n"
                        );
                        System.out.println("Chọn thông tin chỉnh sửa:");
                        int choiceEdit = Integer.parseInt(scanner.nextLine());
                        switch (choiceEdit) {
                            case 1:
                                System.out.println("Nhập tên bệnh nhân mới:");
                                String name = scanner.nextLine();
                                patient.setName(name);
                                break;
                            case 2:
                                System.out.println("Nhập ngày nhập viện mới:");
                                LocalDate admissionDate = LocalDate.parse(scanner.nextLine());
                                patient.setAdmissionDate(admissionDate);
                                break;
                            case 3:
                                System.out.println("Nhập lý do đến khám mới:");
                                String reason = scanner.nextLine();
                                patient.setReason(reason);
                                break;
                            case 4:
                                System.out.println("Nhập số thứ tự bệnh nhân mới:");
                                int id = Integer.parseInt(scanner.nextLine());
                                patient.setId(id);
                                break;
                            case 5:
                                System.out.println("Nhập ngày xuất viện mới:");
                                LocalDate dischargeDate = LocalDate.parse(scanner.nextLine());
                                patient.setDischargeDate(dischargeDate);
                                break;
                            case 6:
                                System.out.println("Nhập mã bệnh án mới:");
                                String code = scanner.nextLine();
                                patient.setCode(code);
                                break;
                            case 7:
                                System.out.println("Nhập phí viện phí mới:");
                                int hospital_stay_fee  = Integer.parseInt(scanner.nextLine());
                                patient.setHospital_stay_fee(hospital_stay_fee);
                                break;
                            case 0:
                                System.out.println("Thoát chỉnh sửa thông tin bệnh nhân!");
                                exit(0);
                            default:
                                System.out.println("Sai lựa chọn! Vui lòng nhập lại.");
                        }
                    }
                }
            }
        } else {
            System.out.println("Không tìm thấy bệnh nhân với số thứ tự " + idUpdate + "!");
        }
    }
}
