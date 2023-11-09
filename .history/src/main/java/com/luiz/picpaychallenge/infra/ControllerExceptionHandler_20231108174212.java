package com.luiz.picpaychallenge.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.luiz.picpaychallenge.dtos.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
  
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException ex){
    ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário ja cadastrado", "400");
    return ResponseEntity.badRequest().body(exceptionDTO);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity threat404(EntityNotFoundException ex){
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity threatGeneralException(Ex ex){
    ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), "500");
    return ResponseEntity.internalServerError().body(exceptionDTO);
  }
}
