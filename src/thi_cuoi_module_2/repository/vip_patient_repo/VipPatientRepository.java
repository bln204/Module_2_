package thi_cuoi_module_2.repository.vip_patient_repo;

import thi_cuoi_module_2.common.IOStreamVipPatient;
import thi_cuoi_module_2.model.VIPPatient;

import java.util.List;

public class VipPatientRepository implements IVipPatientRepo {
    @Override
    public List<VIPPatient> display() {
        return IOStreamVipPatient.convertToListPatient();
    }

    @Override
    public VIPPatient findById(int id) {
        List<VIPPatient> list = IOStreamVipPatient.convertToListPatient();
        for( VIPPatient p : list) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void addPatient(VIPPatient patient) {
        IOStreamVipPatient.addPatientToFile(patient);
    }

    @Override
    public void update(VIPPatient patient) {
        List<VIPPatient> list = IOStreamVipPatient.convertToListPatient();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == patient.getId()) {
                list.set(i, patient);
                break;
            }
        }
        IOStreamVipPatient.importPatientToFile(list);
    }

    @Override
    public void delete(int id) {
    List<VIPPatient> list = IOStreamVipPatient.convertToListPatient();
    for(int i = 0; i < list.size(); i++) {
        if(list.get(i).getId() == id) {
            list.remove(i);
            break;
        }
    }
    IOStreamVipPatient.importPatientToFile(list);
    }
}
