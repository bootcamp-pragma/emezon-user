package com.emezon.user.infra.advices;

import com.emezon.user.app.errorhandling.IApiControllerErrorHandling;
import com.emezon.user.domain.constants.UserErrorMessages;
import com.emezon.user.domain.utils.ExceptionResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDate;
import java.util.List;

@ControllerAdvice
public class ApiControllerAdvice implements IApiControllerErrorHandling<WebRequest> {

    @Override
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(Exception ex, WebRequest request) {
        MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> errorsMessages = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).toList();
        String messages = String.join(",\n ", errorsMessages);
        ExceptionResponse response = new ExceptionResponse(
                messages,
                request.getDescription(false),
                status.value());
        return new ResponseEntity<>(response, status);
    }

    @Override
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(Exception ex, WebRequest request) {
        HandlerMethodValidationException e = (HandlerMethodValidationException) ex;
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> errorMessages = e.getAllValidationResults().stream().map(ParameterValidationResult::getResolvableErrors)
                .flatMap(List::stream).map(MessageSourceResolvable::getDefaultMessage).toList();
        String message = String.join(",\n ", errorMessages);
        ExceptionResponse response = new ExceptionResponse(
                message,
                request.getDescription(false),
                status.value());
        return new ResponseEntity<>(response, status);
    }

    @Override
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidFormatException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Throwable cause = ex.getCause();
        String message = ex.getMessage();
        if (cause instanceof InvalidFormatException invalidFormatEx) {
            if (invalidFormatEx.getTargetType() == LocalDate.class &&
                    invalidFormatEx.getPath() != null &&
                    !invalidFormatEx.getPath().isEmpty() &&
                    "birthdate".equals(invalidFormatEx.getPath().get(0).getFieldName())) {
                message = UserErrorMessages.USER_BIRTHDATE_INVALID;
            }
        }

        ExceptionResponse response = new ExceptionResponse(
                message,
                request.getDescription(false),
                status.value());
        return new ResponseEntity<>(response, status);
    }

}
