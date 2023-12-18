package by.itstep.hospital.controller;

import by.itstep.hospital.model.Patient;
import by.itstep.hospital.service.PatientService;
import by.itstep.hospital.service.PatientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientServiceImpl patientService;

    @GetMapping("/")
    public String showMenu(){
        return "index";
    }

    @GetMapping("/patients")
    public String showPatientsList(Model model){
        Iterable<Patient> patientsList = patientService.findAll();
        model.addAttribute("patientsList", patientsList);
        return "patients";
    }
}
