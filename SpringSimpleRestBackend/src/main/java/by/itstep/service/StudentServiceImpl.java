package by.itstep.service;

import by.itstep.repository.StudentRepository;
import by.itstep.student.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService{


    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

}
