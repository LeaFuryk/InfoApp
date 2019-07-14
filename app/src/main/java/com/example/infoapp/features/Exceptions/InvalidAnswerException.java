package com.example.infoapp.features.Exceptions;

public class InvalidAnswerException extends Exception {
    public InvalidAnswerException(){
        super("You must complete the entire form first");
    }
}
