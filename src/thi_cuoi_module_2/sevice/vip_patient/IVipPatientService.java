package thi_cuoi_module_2.sevice.vip_patient;

import thi_cuoi_module_2.model.VIPPatient;

import java.util.List;

public interface IVipPatientService {
    List<VIPPatient> display();
    VIPPatient findById(int id);
    void addPatient(VIPPatient patient);
    void update(VIPPatient patient);
    void delete(int id);
}
