package thi_cuoi_module_2.repository.regular_patient_repo;

import thi_cuoi_module_2.model.RegularPatient;

import java.util.List;

public interface IRegularPatientRepo {
    List<RegularPatient> display();
    RegularPatient findById(int id);
    void addPatient(RegularPatient patient);
    void update(RegularPatient patient);
    void delete(int id);
}
