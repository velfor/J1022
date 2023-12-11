package by.itstep.h2db.controller;

import by.itstep.h2db.dto.Student;
import by.itstep.h2db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    private List<String> names = Arrays.asList("Иван","Владимир","Борис","Николай","Олег");
    private List<String> surnames = Arrays.asList(
            "Иванов","Владимиров","Борисов","Николаев","Кошевой");

    @GetMapping("create")
    public Student createStudent(){
        Random gen = new Random();
        int indexN = gen.nextInt(4);
        int indexS = gen.nextInt(4);
        String fullName = names.get(indexN) + " " + surnames.get(indexS);
        double avgMark = gen.nextInt(30,100)/10.0;
        Student stud = new Student();
        stud.setFullName(fullName);
        stud.setAvgMark(avgMark);
        return studentRepository.save(stud);
    }

    @GetMapping("students")
    public Iterable<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("students/{id}")
    public Optional<Student> findById(@PathVariable Integer id){
        return studentRepository.findById(id);
    }

    @PostMapping("students")
    public Student postStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }


}
