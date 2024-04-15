package springapp.medical.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Data
@Entity
@NoArgsConstructor
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "details")
    private String details;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public MedicalRecord(Integer id, String details, Patient patient) {
        this.id = id;
        this.details = details;
        this.patient = patient;
    }
}