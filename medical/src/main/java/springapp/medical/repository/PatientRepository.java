package springapp.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springapp.medical.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{}