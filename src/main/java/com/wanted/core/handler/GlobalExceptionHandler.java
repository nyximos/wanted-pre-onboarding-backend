package com.wanted.core.handler;

import com.wanted.core.exception.WantedException;
import com.wanted.core.wrapper.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WantedException.class)
    public ResultResponse handleWantedException(WantedException ex) {
        return new ResultResponse<>(ex.getHttpStatus(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(x -> sb.append(x).append("\n"));
        errors.values().forEach(x -> sb.append(x).append("\n"));
        return new ResultResponse<>(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), sb.toString().trim());
    }
}
