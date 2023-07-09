package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/* Metodo para tratar exceção e modificar o tipo de erro caso tente buscar um usuario que não existe
 *  
 */

@RestControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{     
    
    @ExceptionHandler(ResourceNotFoundException.class) // Anotação para interceptar exceções do tipo ResourceNotFound
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; // Usado para mudar o tipo de codigo vai ser apresentado caso estoure uma exceção
        
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); //Este é o corpo que vai aparecer caso não encontre um usuario

        return ResponseEntity.status(status).body(err);
    }


    @ExceptionHandler(DatabaseException.class) // Anotação para interceptar exceções do tipo ResourceNotFound
    public ResponseEntity<StandardError> dataBaseViolation(DatabaseException e, HttpServletRequest request) {

        String error = "Data Base Error";
        HttpStatus status = HttpStatus.BAD_REQUEST; // Usado para mudar o tipo de codigo vai ser apresentado caso estoure uma exceção
        
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); //Este é o corpo que vai aparecer caso não encontre um usuario

        return ResponseEntity.status(status).body(err);
    }     
     
}