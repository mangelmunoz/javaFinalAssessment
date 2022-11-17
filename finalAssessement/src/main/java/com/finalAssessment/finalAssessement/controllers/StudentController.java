package com.finalAssessment.finalAssessement.controllers;

import com.finalAssessment.finalAssessement.models.Student;
import com.finalAssessment.finalAssessement.services.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/all")
    public List<Student> getAllStudents(){
        return new ArrayList<>();
    }

    @PostMapping(value = "/add")
    public Student postStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

}
