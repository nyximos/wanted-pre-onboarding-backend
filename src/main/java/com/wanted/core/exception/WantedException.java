package com.wanted.core.exception;

import com.wanted.core.exception.code.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class WantedException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public WantedException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.httpStatus = httpStatus;
        this.message = errorCode.getDefaultMessage();
    }

}