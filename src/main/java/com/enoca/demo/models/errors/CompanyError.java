package com.enoca.demo.models.errors;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

public enum CompanyError {

    BAD_PARAM_BODY(HttpStatus.BAD_REQUEST, 980003),
    BAD_PARAM_VALIDATION(HttpStatus.BAD_REQUEST, 980004);

    private final HttpStatus status;
    private final Integer code;

    CompanyError(HttpStatus status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}
