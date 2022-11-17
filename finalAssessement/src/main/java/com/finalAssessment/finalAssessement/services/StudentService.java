package com.finalAssessment.finalAssessement.services;

import com.finalAssessment.finalAssessement.models.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return new ArrayList<>();
    }

    public Student addStudent(){
        return new Student();
    }

}
