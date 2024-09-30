package com.emezon.user.domain.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
    private Integer errorCode;
    private String details;
    private LocalDateTime timestamp;

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
}