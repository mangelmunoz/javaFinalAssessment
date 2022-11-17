package com.finalAssessment.finalAssessement.services;

import com.finalAssessment.finalAssessement.models.Student;
import com.finalAssessment.finalAssessement.repositories.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> getStudents(){
        return (List) studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

}
