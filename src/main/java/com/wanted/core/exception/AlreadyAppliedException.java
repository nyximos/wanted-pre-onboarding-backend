package com.wanted.core.exception;

import com.wanted.core.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;

public class AlreadyAppliedException extends WantedException {

    public AlreadyAppliedException() {
        super(HttpStatus.NOT_FOUND, ErrorCode.ALREADY_APPLIED);
    }

    public AlreadyAppliedException(ErrorCode errorCode) {
        super(HttpStatus.CONFLICT, errorCode);
    }

    public AlreadyAppliedException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(httpStatus, errorCode);
    }
}