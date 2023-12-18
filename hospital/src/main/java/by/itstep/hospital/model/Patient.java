package by.itstep.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String fullName;
    private LocalDate dateOfBirth;
    @Column(length = 100)
    private String diagnosis;
    private LocalDate dateOfAdmission;
    private LocalDate dateOfDischarge;
    private Long departmentId;
}
