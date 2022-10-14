package com.francisco.estudo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<StandardError> unauthorized (AuthenticationException ex, HttpServletRequest request, HttpServletResponse response){
        if(ex instanceof BadCredentialsException){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        String status = HttpStatus.valueOf(response.getStatus()).toString();
        StandardError erro = new StandardError(status, LocalDateTime.now(), request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(response.getStatus()).body(erro);
    }



}
