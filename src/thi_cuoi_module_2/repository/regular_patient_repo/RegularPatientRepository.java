package thi_cuoi_module_2.repository.regular_patient_repo;

import thi_cuoi_module_2.common.IOStreamRegularPatient;
import thi_cuoi_module_2.model.RegularPatient;

import java.util.List;

public class RegularPatientRepository implements IRegularPatientRepo {
    @Override
    public List<RegularPatient> display() {
        return IOStreamRegularPatient.convertToListPatient();
    }

    @Override
    public RegularPatient findById(int id) {
        List<RegularPatient> list = IOStreamRegularPatient.convertToListPatient();
        for( RegularPatient s : list) {
            if(s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void addPatient(RegularPatient patient) {
        IOStreamRegularPatient.addPatientToFile(patient);

    }

    @Override
    public void update(RegularPatient patient) {
        List<RegularPatient> list = IOStreamRegularPatient.convertToListPatient();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == patient.getId()) {
                list.set(i, patient);
                break;
            }
        }
        IOStreamRegularPatient.importPatientToFile(list);
    }

    @Override
    public void delete(int id) {
        List<RegularPatient> list = IOStreamRegularPatient.convertToListPatient();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        IOStreamRegularPatient.importPatientToFile(list);
    }
}
