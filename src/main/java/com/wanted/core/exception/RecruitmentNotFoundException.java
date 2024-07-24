package com.wanted.core.exception;

import com.wanted.core.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;

public class RecruitmentNotFoundException extends WantedException {

    public RecruitmentNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCode.RECRUITMENT_NOT_FOUND);
    }

    public RecruitmentNotFoundException(ErrorCode errorCode) {
        super(HttpStatus.NOT_FOUND, errorCode);
    }

    public RecruitmentNotFoundException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(httpStatus, errorCode);
    }
}