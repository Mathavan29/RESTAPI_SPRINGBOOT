package springapp.medical.service;
import lombok.NonNull;
import springapp.medical.model.Patient;
import springapp.medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(@NonNull Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(@NonNull Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    public boolean updatePatient(int id, Patient patient) {
        if (getPatientById(id) == null) {
            return false;
        }
        try {
            patient.setId(id);
            patientRepository.save(patient);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deletePatient(int id) {
        if (getPatientById(id) == null) {
            return false;
        }
        patientRepository.deleteById(id);
        return true;
    }
}