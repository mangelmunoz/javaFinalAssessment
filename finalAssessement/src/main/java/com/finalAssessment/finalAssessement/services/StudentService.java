package com.finalAssessment.finalAssessement.services;

import com.finalAssessment.finalAssessement.exceptions.WrongSyntaxEmailException;
import com.finalAssessment.finalAssessement.models.Student;
import com.finalAssessment.finalAssessement.repositories.StudentRepository;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) throws WrongSyntaxEmailException {
        //Regular Expression
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(student.getEmail());
        if(!matcher.matches()){
            throw new WrongSyntaxEmailException("The email is not valid");
        }
        return studentRepository.save(student);
    }

}
