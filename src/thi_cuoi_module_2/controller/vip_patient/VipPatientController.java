package thi_cuoi_module_2.controller.vip_patient;

import thi_cuoi_module_2.model.VIPPatient;
import thi_cuoi_module_2.sevice.vip_patient.IVipPatientService;
import thi_cuoi_module_2.sevice.vip_patient.VipPatientService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class VipPatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static IVipPatientService vipPatientService = new VipPatientService();

    public void displayPatient() {
        List<VIPPatient> patientList = vipPatientService.display();
        for (VIPPatient patient : patientList) {
            System.out.println(patient);
        }
    }

    public void addPatient() {
        System.out.println("Nhập số bệnh nhân VIP cần thêm:");
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin bệnh nhân VIP thứ " + (i + 1) + ":");
            System.out.println("Nhập ngày nhập viện:");
            LocalDate admissionDate = LocalDate.parse(scanner.nextLine());
            System.out.println("Nhập lý do đến khám:");
            String reason = scanner.nextLine();
            System.out.println("Nhập tên bệnh nhân:");
            String name = scanner.nextLine();
            System.out.println("Nhập số thứ tự bệnh nhân:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập ngày xuất viện:");
            LocalDate dischargeDate = LocalDate.parse(scanner.nextLine());
            System.out.println("Nhập mã bệnh án:");
            String code = scanner.nextLine();
            System.out.println("Nhập loại bệnh nhân VIP:");
            String typeVip = scanner.nextLine();
            System.out.println("Nhập thời hạn VIP của bệnh nhân:");
            int vipStatus = Integer.parseInt(scanner.nextLine());
            VIPPatient patient = new VIPPatient(admissionDate, reason, name, id, dischargeDate, code, typeVip, vipStatus);
            vipPatientService.addPatient(patient);
        }
        System.out.println("Đã thêm thành công bệnh nhân!");
        System.out.println();
    }

    public boolean isExit(int id) {
        VIPPatient patient = vipPatientService.findById(id);
        return patient != null;
    }

    public void delete() {
        System.out.println("Nhập số thứ tự bệnh nhân cần xóa:");
        int idDelete = Integer.parseInt(scanner.nextLine());
        if (isExit(idDelete)) {
            vipPatientService.delete(idDelete);
            System.out.println("Đã xóa thành công bệnh nhân với số thứ tự " + idDelete + "!");
        } else {
            System.out.println("Không tìm thấy bệnh nhân với số thứ tự " + idDelete + "!");
        }
        System.out.println();
    }

    public void update() {
        System.out.println("Nhập số thứ tự bệnh nhân cần cập nhật:");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        List<VIPPatient> vipPatients = new ArrayList<VIPPatient>();

        if (isExit(idUpdate)) {
            for(VIPPatient patient : vipPatients) {
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
                                "7. Loại bệnh nhân VIP. \n" +
                                "8. Th��i hạn VIP của bệnh nhân. \n" +
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
                                    System.out.println("Nhập loại bệnh nhân VIP mới:");
                                    String typeVip = scanner.nextLine();
                                    patient.setTypeVip(typeVip);
                                    break;
                                case 8:
                                    System.out.println("Nhập th��i hạn VIP của bệnh nhân mới:");
                                    int vipStatus = Integer.parseInt(scanner.nextLine());
                                    patient.setVipStatus(vipStatus);
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
