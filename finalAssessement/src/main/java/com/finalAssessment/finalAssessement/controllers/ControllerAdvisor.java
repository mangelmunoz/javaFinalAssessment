package com.finalAssessment.finalAssessement.controllers;

import com.finalAssessment.finalAssessement.exceptions.WrongSyntaxEmailException;
import com.finalAssessment.finalAssessement.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(WrongSyntaxEmailException.class)
    public ResponseEntity<Student> handleWrongEmail(WrongSyntaxEmailException exception, WebRequest request){
        System.out.println("I'm handling the exception");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
