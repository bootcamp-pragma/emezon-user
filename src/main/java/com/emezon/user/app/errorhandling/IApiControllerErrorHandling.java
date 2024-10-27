package com.emezon.user.app.errorhandling;

public interface IApiControllerErrorHandling<T> {

    Object handleMethodArgumentNotValidException(Exception ex, T request);

    Object handleConstraintViolationException(Exception ex, T request);

    Object handleInvalidFormatException(Exception ex, T request);

}
