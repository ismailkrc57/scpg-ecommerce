package com.maltepe.scpg.core.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ErrorModel {
    private HttpStatus httpStatus;
    private String message;
    private Map<String,String> errors;

    public ErrorModel(HttpStatus httpStatus, String message, Map<String, String> errors) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }
}
