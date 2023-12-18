package by.itstep.hospital.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PatientController {

    @GetMapping("/")
    public String showMenu(){
        return "index";
    }
}
