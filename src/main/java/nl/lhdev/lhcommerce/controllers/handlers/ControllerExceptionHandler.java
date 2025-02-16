package nl.lhdev.lhcommerce.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import nl.lhdev.lhcommerce.dto.CustomError;
import nl.lhdev.lhcommerce.services.exceptions.DataBaseException;
import nl.lhdev.lhcommerce.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    // @ExceptionHandler - para capturar exceções específicas

    // metodo que capta ResourceNotFound.class 
    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
       HttpStatus status = HttpStatus.NOT_FOUND;
       CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

       return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<CustomError> database(DataBaseException e, HttpServletRequest request) {
      HttpStatus status = HttpStatus.BAD_REQUEST;
      CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

      return ResponseEntity.status(status).body(err);
   }
}