package by.itstep.hospital.controller;

import by.itstep.hospital.model.Patient;
import by.itstep.hospital.service.PatientService;
import by.itstep.hospital.service.PatientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientServiceImpl patientService;

    private final int PAGE_SIZE = 5;

    @ModelAttribute("allDiagnosis")
    public List<String> addDiagnosisToModel(){
        return Arrays.asList("Пневмония", "Атипичная пневмония", "Ангина");
    }

    @GetMapping("/")
    public String showMenu(){
        return "index";
    }

    @GetMapping("/patients")
    public String showPatientsList(Model model)
    {
        return showPatientsListPaginated(1, "fullName", "asc", model);
    }
    // /page/1?sortField="fullName"&sortDir="asc"
    @GetMapping("/page/{pageNumber}")
    public String showPatientsListPaginated(@PathVariable(value = "pageNumber") int pageNumber,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir,
            Model model){
        var page = patientService.findPaginated(pageNumber, PAGE_SIZE);
        var patientsList = page.getContent();

        model.addAttribute("patients", patientsList);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

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
