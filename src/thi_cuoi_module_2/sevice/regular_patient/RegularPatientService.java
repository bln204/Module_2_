package thi_cuoi_module_2.sevice.regular_patient;

import thi_cuoi_module_2.model.RegularPatient;
import thi_cuoi_module_2.repository.regular_patient_repo.IRegularPatientRepo;
import thi_cuoi_module_2.repository.regular_patient_repo.RegularPatientRepository;

import java.util.List;

public class RegularPatientService implements IRegularPatientService {
    private final IRegularPatientRepo iRegularPatient = new RegularPatientRepository();

    @Override
    public List<RegularPatient> display() {
        return iRegularPatient.display();
    }

    @Override
    public RegularPatient findById(int id) {
        return iRegularPatient.findById(id);
    }

    @Override
    public void addPatient(RegularPatient patient) {
        List<RegularPatient> list = display();
        int id;
        if(list.isEmpty()) {
            id = 1;
            patient.setId(id);
        } else {
            id = list.get(list.size() - 1).getId() + 1;
            patient.setId(id);
        }
        iRegularPatient.addPatient(patient);
    }

    @Override
    public void update(RegularPatient patient) {
        iRegularPatient.update(patient);
    }

    @Override
    public void delete(int id) {
        iRegularPatient.delete(id);

    }
}
