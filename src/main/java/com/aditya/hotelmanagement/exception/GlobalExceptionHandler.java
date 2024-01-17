package com.aditya.hotelmanagement.exception;

import com.aditya.hotelmanagement.customresponse.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException ex) {
        ApiResponse response = new ApiResponse("Error", ex.getMessage(), null);
        return ResponseEntity.status(400).body(response);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException ex) {
        ApiResponse response = new ApiResponse("Error", ex.getMessage(), null);
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        ApiResponse response = new ApiResponse("Error", ex.getMessage(), null);
        return ResponseEntity.status(500).body(response);
    }


}

