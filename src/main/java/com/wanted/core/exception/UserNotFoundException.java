package com.wanted.core.exception;

import com.wanted.core.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends WantedException {

    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCode.USER_NOT_FOUND);
    }

    public UserNotFoundException(ErrorCode errorCode) {
        super(HttpStatus.NOT_FOUND, errorCode);
    }

    public UserNotFoundException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(httpStatus, errorCode);
    }
}