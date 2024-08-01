package thi_cuoi_module_2.model;

import java.time.LocalDate;

public abstract class Patient {
    private int id;
    private String name;
    private String code;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String reason;

    public Patient(LocalDate admissionDate, String reason, String name, int id, LocalDate dischargeDate, String code) {
        this.admissionDate = admissionDate;
        this.reason = reason;
        this.name = name;
        this.id = id;
        this.dischargeDate = dischargeDate;
        this.code = code;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "admissionDate=" + admissionDate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", dischargeDate=" + dischargeDate +
                ", reason='" + reason + '\'' +
                '}';
    }
}
