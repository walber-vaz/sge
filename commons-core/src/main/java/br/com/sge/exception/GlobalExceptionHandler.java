package br.com.sge.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<DefaultErrorMessage> handleNotFoundException(
      NotFoundException exception, HttpServletRequest request) {
    log.error("Not found exception: {}", exception.getReason());

    var errorMessage = new DefaultErrorMessage(
        exception.getReason(),
        request.getRequestURI(),
        request.getMethod(),
        HttpStatus.NOT_FOUND.value()
    );

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }

  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public ResponseEntity<DefaultErrorMessage> handleSQLIntegrityConstraintViolationException(
      SQLIntegrityConstraintViolationException exception, HttpServletRequest request) {
    log.error("Not found exception duplicate and constraint: {}", exception.getMessage());

    var errorMessage = new DefaultErrorMessage(
        "Duplicate entry for one of the unique fields",
        request.getRequestURI(),
        request.getMethod(),
        HttpStatus.CONFLICT.value()
    );

    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
  }

  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<DefaultErrorMessage> handleConflictException(
      ConflictException exception, HttpServletRequest request) {
    log.error("Conflict exception: {}", exception.getReason());

    var errorMessage = new DefaultErrorMessage(
        exception.getReason(),
        request.getRequestURI(),
        request.getMethod(),
        HttpStatus.CONFLICT.value()
    );

    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
  }
}
