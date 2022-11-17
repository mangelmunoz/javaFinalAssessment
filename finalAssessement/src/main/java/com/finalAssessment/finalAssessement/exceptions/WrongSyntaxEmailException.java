package com.finalAssessment.finalAssessement.exceptions;

public class WrongSyntaxEmailException extends Exception {

    public String message;

    public WrongSyntaxEmailException(String message) {
        super(message);
    }
}
