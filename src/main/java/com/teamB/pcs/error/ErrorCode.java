package com.teamB.pcs.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INVALID_TAG(BAD_REQUEST, "태그를 찾을 수 없습니다");


    private final int code;
    private final String message;

    ErrorCode(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }
}
