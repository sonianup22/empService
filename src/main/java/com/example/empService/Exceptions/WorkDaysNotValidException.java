package com.example.empService.Exceptions;

public class WorkDaysNotValidException extends RuntimeException{
    public WorkDaysNotValidException() {
    }

    public WorkDaysNotValidException(String message) {
        super(message);
    }
}
