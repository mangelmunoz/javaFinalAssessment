package com.finalAssessment.finalAssessement.controllers;

import com.finalAssessment.finalAssessement.exceptions.WrongSyntaxEmailException;
import com.finalAssessment.finalAssessement.models.Student;
import com.finalAssessment.finalAssessement.services.StudentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Student> postStudent(@Valid @RequestBody Student student) throws WrongSyntaxEmailException {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteStudent(@PathVariable(value = "id") Integer id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) throws WrongSyntaxEmailException {
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.CREATED);
    }

}
