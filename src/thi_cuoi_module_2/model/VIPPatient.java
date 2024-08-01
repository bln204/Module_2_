package thi_cuoi_module_2.model;

import java.time.LocalDate;

public class VIPPatient extends Patient {
    private String typeVip;
    private int vipStatus;
    public VIPPatient(LocalDate admissionDate, String reason, String name, int id, LocalDate dischargeDate, String code, String typeVip, int vipStatus) {
        super(admissionDate, reason, name, id, dischargeDate, code);
        this.typeVip = typeVip;
        this.vipStatus = vipStatus;
    }

    public String getTypeVip() {
        return typeVip;
    }

    public void setTypeVip(String typeVip) {
        this.typeVip = typeVip;
    }

    public int getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(int vipStatus) {
        this.vipStatus = vipStatus;
    }


    public String convertToLine(){
        return super.getId()+ "," + super.getCode() + "," + super.getName() + "," + super.getAdmissionDate() + "," + super.getDischargeDate() + "," + typeVip + vipStatus;
    }
    @Override
    public String toString() {
        return "VIPPatient{" +
                "typeVip='" + typeVip + '\'' +
                ", vipStatus=" + vipStatus + '\'' +
                super.toString() + '}';
    }
}
