package com.managementSystem.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    public String getMessege() {
        return messege;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    private String messege;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

    public ApiException(String messege, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.messege = messege;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
