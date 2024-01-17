package by.itstep.hospital.service;

import by.itstep.hospital.model.Department;
import by.itstep.hospital.model.Patient;
import by.itstep.hospital.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    private Patient patient;

    @BeforeEach
    void createPatient(){
        this.patient = Patient.builder()
                .fullName("Тест Тестов")
                .gender("мужской")
                .dateOfBirth(LocalDate.of(1990,01,01))
                .diagnosis("Ангина")
                .dateOfAdmission(LocalDate.of(2020,9,01))
                .dateOfDischarge(LocalDate.of(2020,9,10))
                .department(new Department())
                .build();
    }

    @Test
    void findAllTest() {
        List<Patient> patients = new ArrayList<>();
        patients.add(Patient.builder()
                .fullName("Иванов Иван Иванович")
                .diagnosis("Вывих")
                .build()
        );
        patients.add(Patient.builder()
                .fullName("Петров Петр Петрович")
                .diagnosis("Перелом")
                .build()
        );

        when(patientRepository.findAll()).thenReturn(patients);

        List<Patient> expected = StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(expected.size(), 2);
        assertEquals(expected.get(0).getFullName(),"Иванов Иван Иванович");
    }


    @Test
    void whenSave_thenSaveAndReturnPatient() {
        when(patientRepository.save(any(Patient.class))).thenReturn(this.patient);

        Patient savedPatient = patientService.save(this.patient);

        assertNotNull(savedPatient);
        assertSame(this.patient, savedPatient);
        verify(patientRepository).save(this.patient);
    }

    @Test
    void whenFindPaginated_ShouldReturnPage(){
        Page<Patient> expectedPage = new PageImpl<>(List.of(this.patient));

        when(patientRepository.findAll(any(PageRequest.class))).thenReturn(expectedPage);

        Page<Patient> actualPage = patientService.findPaginatedAndSorted(1,1,"fullName", "asc");

        assertEquals(1, actualPage.getTotalElements());
        assertSame(this.patient, actualPage.getContent().get(0));
        verify(patientRepository).findAll(any(PageRequest.class));
    }

    @Test
    void whenFindByIdAndPatientExist_thenReturnOptionalOfPatient(){
        when(patientRepository.findById(anyLong())).thenReturn(Optional.of(this.patient));

        Optional<Patient> actualPatient = patientService.findById(1L);

        assertTrue(actualPatient.isPresent());
        assertEquals(this.patient.getFullName(), actualPatient.get().getFullName());
        assertSame(this.patient, actualPatient.get());
        verify(patientRepository).findById(1L);
    }

    @Test
    void whenFindByIdAndPatientNotExist_ShouldReturnEmptyOptional(){
        when(patientRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Patient> actualPatient = patientService.findById(1L);
        assertTrue(actualPatient.isEmpty());
    }

    @Test
    void whenExistByIdAndPatientExist_thenShouldReturnTrue(){
        when(patientRepository.existsById(anyLong())).thenReturn(true);

        boolean actual = patientService.existsById(1L);

        assertTrue(actual);
    }
}