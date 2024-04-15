package springapp.medical.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springapp.medical.model.Patient;
import springapp.medical.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.createPatient(patient);
        if (newPatient != null) {
            return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        if (!patients.isEmpty()) {
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/patients/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int patientId, @RequestBody Patient patient) {
        boolean updated = patientService.updatePatient(patientId, patient);
        if (updated) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<Boolean> deletePatient(@PathVariable int patientId) {
        boolean deleted = patientService.deletePatient(patientId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}