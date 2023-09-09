package com.teamB.pcs.error.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;
import com.teamB.pcs.error.dto.ErrorResponse;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final Exception e) {
        log.error("Internal Error occurred", e);
        return ResponseEntity.internalServerError().body(ErrorResponse.of(500, e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final BusinessException e) {
        log.info("businessException: {}", e);
        return ResponseEntity.status(e.getCode()).body(ErrorResponse.of(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String firstErrorMessage = bindingResult.getFieldErrors().get(0).getDefaultMessage();

        List<String> errorList = bindingResult.getFieldErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.toList());
        log.warn("MethodArgumentNotValidExceptionException = {}", errorList);

        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.of(BAD_REQUEST.value(), firstErrorMessage));
    }
}