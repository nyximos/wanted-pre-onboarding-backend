package com.wanted.core.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND("해당 자원을 찾을 수 없습니다."),
    BAD_REQUEST("잘못된 요청입니다."),
    COMPANY_NOT_FOUND("해당 회사를 찾을 수 없습니다."),
    RECRUITMENT_NOT_FOUND("해당 채용공고를 찾을 수 없습니다."),
    USER_NOT_FOUND("해당 회원를 찾을 수 없습니다."),
    ALREADY_APPLIED("지원은 한 번만 가능합니다."),
    ;

    private String defaultMessage;

}
