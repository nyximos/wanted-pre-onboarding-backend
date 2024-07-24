package com.wanted.core.exception;

import com.wanted.core.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;

public class CompanyNotFoundException extends WantedException {

    public CompanyNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCode.COMPANY_NOT_FOUND);
    }

    public CompanyNotFoundException(ErrorCode errorCode) {
        super(HttpStatus.NOT_FOUND, errorCode);
    }

    public CompanyNotFoundException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(httpStatus, errorCode);
    }
}