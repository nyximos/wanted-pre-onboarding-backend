package com.wanted.core.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND("해당 자원을 찾을 수 없습니다."),
    BAD_REQUEST("잘못된 요청입니다."),
    COMPANY_NOT_FOUND("해당 회사를 찾을 수 없습니다."),
    ;

    private String defaultMessage;

}
