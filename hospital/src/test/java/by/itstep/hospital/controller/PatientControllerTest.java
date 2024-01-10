package by.itstep.hospital.controller;

import by.itstep.hospital.model.Department;
import by.itstep.hospital.model.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@RequiredArgsConstructor
class PatientControllerTest {

    @Autowired
    private MockMvc mokMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addPAtient() throws Exception {
        mokMvc.perform(get("/add_patient")).andExpect(view().name("add_patient"));
        Patient patient = Patient.builder()
                .fullName("Петров Петр Петрович")
                .diagnosis("Перелом")
                .build();
        mokMvc.perform(post("/add_patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isOk())
                .andExpect(view().name("add_success"));


    }
}