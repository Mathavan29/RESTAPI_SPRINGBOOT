package springapp.medical.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String patientName;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Patient(Integer id, String patientName, int age, List<MedicalRecord> medicalRecords,
            List<Appointment> appointments) {
        this.id = id;
        this.patientName = patientName;
        this.age = age;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
    }
}