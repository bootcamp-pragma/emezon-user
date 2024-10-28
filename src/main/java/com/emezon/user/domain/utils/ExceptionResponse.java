package com.emezon.user.domain.utils;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
    private Integer errorCode;
    private String details;
    private LocalDateTime timestamp;

    public ExceptionResponse() {}

    public ExceptionResponse(String messages, String description, int value) {
        this.errorMessage = messages;
        this.requestedURI = description;
        this.errorCode = value;
        this.timestamp = LocalDateTime.now();
    }

    public ExceptionResponse(String messages, String description, int value, String details) {
        this.errorMessage = messages;
        this.requestedURI = description;
        this.errorCode = value;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestedURI() {
        return requestedURI;
    }

    public void setRequestedURI(String requestedURI) {
        this.requestedURI = requestedURI;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}