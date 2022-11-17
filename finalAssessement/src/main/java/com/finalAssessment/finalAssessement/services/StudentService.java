package com.finalAssessment.finalAssessement.services;

import com.finalAssessment.finalAssessement.exceptions.WrongSyntaxEmailException;
import com.finalAssessment.finalAssessement.models.Student;
import com.finalAssessment.finalAssessement.repositories.StudentRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElse(null);
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

    public Student updateStudent(Student student)throws WrongSyntaxEmailException {

        if(getStudentById(student.getId()) != null){
            return addStudent(student);
        }
        else {
            throw new NoSuchElementException("El estudiante no tiene id");
        }
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        studentRepository.delete(student);
    }

}
