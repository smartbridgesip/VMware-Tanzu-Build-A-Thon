package com.abhicodes.reactapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/students")
public class Controller {

    @Autowired
    private StudentRepository studRepo;

    @GetMapping("/all")
    public List<Student> all(){
        return studRepo.findAll();
    }

    @GetMapping("/init")
    public void saveStudents() {
        studRepo.save(new Student(23,"Gopal","Degree"));
        studRepo.save(new Student(97,"Anil","Degree"));
    }

}
