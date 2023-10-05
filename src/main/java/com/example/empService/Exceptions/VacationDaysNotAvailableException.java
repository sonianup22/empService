package com.example.empService.Exceptions;

public class VacationDaysNotAvailableException extends RuntimeException{
    public VacationDaysNotAvailableException() {
    }

    public VacationDaysNotAvailableException(String message) {
        super(message);
    }
}
