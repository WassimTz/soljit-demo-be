package com.soljit.touzene.demo.exception;

import com.soljit.touzene.demo.model.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@ControllerAdvice
@Slf4j
public class AdviserHandler {
    private static final String FATAL_ERROR = "Une erreur inattendue s'est produite";
    private static final String PAGE_NOT_FOUND = "La ressource demandée n'existe pas";

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<GenericResponse> authException(HttpServletRequest request, AuthException exception) {
        GenericResponse response = new GenericResponse(exception.getMessage(), 400);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CandidatureException.class)
    public ResponseEntity<GenericResponse> candidatureException(HttpServletRequest request, CandidatureException exception) {
        GenericResponse response = new GenericResponse(exception.getMessage(), 400);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> globalException(HttpServletRequest request, Exception exception) {
        log.error(exception.getMessage());
        GenericResponse response = new GenericResponse(exception.getMessage(), 500);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
