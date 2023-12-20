package by.itstep.hospital.controller;

import by.itstep.hospital.model.Patient;
import by.itstep.hospital.service.PatientService;
import by.itstep.hospital.service.PatientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientServiceImpl patientService;

    @ModelAttribute("allDiagnosis")
    public List<String> addDiagnosisToModel(){
        return Arrays.asList("Пневмония", "Атипичная пневмония", "Ангина");
    }

    @GetMapping("/")
    public String showMenu(){
        return "index";
    }

    @GetMapping("/patients")
    public String showPatientsList(Model model){
        Iterable<Patient> patientsList = patientService.findAll();
        model.addAttribute("patients", patientsList);
        return "patients";
    }

    @GetMapping("add_patient")
    public String showPatientInputForm(@ModelAttribute("patient") Patient patient){
        return "add_patient";
    }

    @PostMapping("add_patient")
    public String addPatient(@ModelAttribute("patient") Patient patient){
        patientService.save(patient);
        return "add_patient"; // TODO: поменять страницу на Пациент добавлен
    }
}
