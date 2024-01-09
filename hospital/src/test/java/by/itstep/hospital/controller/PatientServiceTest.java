package by.itstep.hospital.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import by.itstep.hospital.model.Patient;
import by.itstep.hospital.repository.PatientRepository;
import by.itstep.hospital.service.PatientService;
import by.itstep.hospital.service.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientServiceTest {
    @Mock
    private PatientRepository patientRepository;

    //Тест на проверку метода addPatient
    @Test
    public void testAddPatient() {
        PatientService patientService = new PatientServiceImpl(patientRepository);

        Patient patient = new Patient();
        patient.setFullName("John Dori");
        patient.setGender("мужской");

        when(patientRepository.save(patient)).thenReturn(patient);

        Patient savedPatient = patientService.save(patient);

        verify(patientRepository, times(1)).save(patient);
        assertEquals(savedPatient.getFullName(), "John Dori");
        assertEquals(savedPatient.getGender(), "мужской");
    }
}
