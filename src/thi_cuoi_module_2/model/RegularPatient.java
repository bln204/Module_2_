package thi_cuoi_module_2.model;

import java.time.LocalDate;

public class RegularPatient extends Patient {
    private int hospital_stay_fee;
    public RegularPatient(LocalDate admissionDate, String reason, String name, int id, LocalDate dischargeDate, String code, int hospital_stay_fee) {
        super(admissionDate, reason, name, id, dischargeDate, code);
        this.hospital_stay_fee = hospital_stay_fee;
    }

    public int getHospital_stay_fee() {
        return hospital_stay_fee;
    }

    public void setHospital_stay_fee(int hospital_stay_fee) {
        this.hospital_stay_fee = hospital_stay_fee;
    }
    public String convertToLine(){
        return super.getId()+ "," + super.getCode() + "," + super.getName() + "," + super.getAdmissionDate() + "," + super.getDischargeDate() + "," + hospital_stay_fee;
    }

    @Override
    public String toString() {
        return "RegularPatient{" +
                "hospital_stay_fee=" + hospital_stay_fee + '\''
                + super.toString();
    }
}
