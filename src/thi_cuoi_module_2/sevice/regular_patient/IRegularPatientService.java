package thi_cuoi_module_2.sevice.regular_patient;

import thi_cuoi_module_2.model.RegularPatient;

import java.util.List;

public interface IRegularPatientService {
    List<RegularPatient> display();
    RegularPatient findById(int id);
    void addPatient(RegularPatient patient);
    void update(RegularPatient patient);
    void delete(int id);
}
