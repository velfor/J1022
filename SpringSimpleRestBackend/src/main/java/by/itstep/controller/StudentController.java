package by.itstep.controller;

import by.itstep.repository.StudentRepository;
import by.itstep.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public Iterable<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getById(@PathVariable Integer id){
        return studentRepository.findById(id);
    }
}
