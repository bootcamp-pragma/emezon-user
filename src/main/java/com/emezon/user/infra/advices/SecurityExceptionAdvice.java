package com.emezon.user.infra.advices;

import com.emezon.user.domain.utils.ExceptionResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Order(10)
public class SecurityExceptionAdvice {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                request.getDescription(false),
                status.value());
        return new ResponseEntity<>(response, status);
    }

}
