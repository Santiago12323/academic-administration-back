package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest;

import com.santiago.coronado.academic_administration.domain.exception.BusinessRuleException;
import com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<ErrorResponse> handleBusinessRuleException(BusinessRuleException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .error(ex.getMessage())
                .time(LocalDateTime.now())
                .state("BUSINESS_RULE_VIOLATION")
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse error = ErrorResponse.builder()
                .error("An unexpected error occurred: " + ex.getMessage())
                .time(LocalDateTime.now())
                .state("INTERNAL_SERVER_ERROR")
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}