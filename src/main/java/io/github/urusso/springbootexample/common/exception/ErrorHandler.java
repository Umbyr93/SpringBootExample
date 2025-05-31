package io.github.urusso.springbootexample.common.exception;

import io.github.urusso.springbootexample.common.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("Exception: {}", ex.getMessage(), ex);

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<?> authorizationException(AuthorizationException ex) {
        log.error("EException: {}", ex.getMessage(), ex);

        var errorDto = new ErrorDto(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(errorDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericException(Exception ex) {
        log.error("Exception: {}", ex.getMessage(), ex);

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage() != null ? ex.getMessage() : "Unexpected error");

        return ResponseEntity.internalServerError().body(error);
    }
}
