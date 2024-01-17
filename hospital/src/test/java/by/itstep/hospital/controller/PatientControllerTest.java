package by.itstep.hospital.controller;

import by.itstep.hospital.model.Department;
import by.itstep.hospital.model.Patient;
import by.itstep.hospital.service.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTest {

    @Autowired
    private MockMvc mokMvc;

    @MockBean
    private PatientServiceImpl patientService;

    @Test
    void whenShowMenu_thenReturnIndexPage() throws Exception{
        mokMvc.perform(get("/"))
                .andExpect(view().name("index"))
                .andExpect(status().isOk());
    }

    @Test
    void addPAtient() throws Exception {
        mokMvc.perform(get("/add_patient"))
                .andExpect(view().name("add_patient"))
                .andExpect(status().is2xxSuccessful()); //status.isOk()
    }

    @Test
    void whenGetPatientById_thenCheckViewAndCheckStatus() throws Exception {
        Patient patient = new Patient();

        when(patientService.findById(1L)).thenReturn(Optional.of(patient));

        mokMvc.perform(get("/showFormForUpdate/1")).
                andExpect(status().is2xxSuccessful()).
                andExpect(model().attributeExists("patient"));
    }

    @Test
    void whenPostPatient_thenCheckViewAndCheckStatus() throws Exception{

        mokMvc.perform(post("/add_patient"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("add_success"));
    }

    @Test
    void testUpdatePatientFormSubmitedData() throws Exception{
        Patient expectedPatient = Patient.builder()
                .fullName("Тест Тестов")
                .gender("мужской")
                .dateOfBirth(LocalDate.of(1990,01,01))
                .diagnosis("Ангина")
                .build();

        when(patientService.save(any(Patient.class))).thenReturn(expectedPatient);

        mokMvc.perform(post("/save")
                .param("fullName","Тест Тестов")
                .param("gender","мужской")
                .param("dateOfBirth","1990-01-01")
                .param("diagnosis", "Ангина")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/patients"));
    }

    @Test
    void testGetPatientById_thenDataSavedToModel() throws Exception{
        Patient expectedPatient = Patient.builder()
                .fullName("Тест Тестов")
                .gender("мужской")
                .dateOfBirth(LocalDate.of(1990,01,01))
                .diagnosis("Ангина")
                .dateOfAdmission(LocalDate.of(2020,9,01))
                .dateOfDischarge(LocalDate.of(2020,9,10))
                .department(new Department())
                .build();

        when(patientService.findById(anyLong())).thenReturn(Optional.of(expectedPatient));

        MvcResult result = mokMvc.perform(get("/showFormForUpdate/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("patient"))
                .andReturn();

        Patient actualPatient = (Patient) result.getModelAndView().getModel().get("patient");

        assertEquals(expectedPatient.getId(), actualPatient.getId());
        assertEquals(expectedPatient.getFullName(), actualPatient.getFullName());
        assertEquals(expectedPatient.getGender(), actualPatient.getGender());
        assertEquals(expectedPatient.getDateOfBirth(), actualPatient.getDateOfBirth());
    }

}