package thi_cuoi_module_2.sevice.vip_patient;

import thi_cuoi_module_2.model.VIPPatient;
import thi_cuoi_module_2.repository.vip_patient_repo.IVipPatientRepo;
import thi_cuoi_module_2.repository.vip_patient_repo.VipPatientRepository;

import java.util.List;

public class VipPatientService implements IVipPatientService {
    private final IVipPatientRepo iVipPatient = new VipPatientRepository();

    @Override
    public List<VIPPatient> display() {
        return iVipPatient.display();
    }

    @Override
    public VIPPatient findById(int id) {
        return iVipPatient.findById(id);
    }

    @Override
    public void addPatient(VIPPatient patient) {
        List<VIPPatient> list = display();
        int id;
        if(list.isEmpty()) {
            id = 1;
            patient.setId(id);
        } else {
            id = list.get(list.size() - 1).getId() + 1;
            patient.setId(id);
        }
        iVipPatient.addPatient(patient);

    }

    @Override
    public void update(VIPPatient patient) {
        iVipPatient.update(patient);
    }

    @Override
    public void delete(int id) {
        iVipPatient.delete(id);
    }
}
