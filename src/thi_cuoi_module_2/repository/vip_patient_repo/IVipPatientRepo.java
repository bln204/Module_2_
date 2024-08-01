package thi_cuoi_module_2.repository.vip_patient_repo;

import thi_cuoi_module_2.model.VIPPatient;

import java.util.List;

public interface IVipPatientRepo {
    List<VIPPatient> display();
    VIPPatient findById(int id);
    void addPatient(VIPPatient patient);
    void update(VIPPatient patient);
    void delete(int id);
}
