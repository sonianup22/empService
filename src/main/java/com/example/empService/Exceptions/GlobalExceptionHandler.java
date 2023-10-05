package com.example.empService.Exceptions;

import com.example.empService.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(VacationDaysNotAvailableException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(VacationDaysNotAvailableException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.BAD_REQUEST).build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(WorkDaysNotValidException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(WorkDaysNotValidException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.BAD_REQUEST).build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);

    }
}

