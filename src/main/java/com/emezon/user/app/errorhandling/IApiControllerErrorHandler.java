package com.emezon.user.app.errorhandling;

public interface IApiControllerErrorHandler<T> {

    Object handleMethodArgumentNotValidException(Exception ex, T request);

    Object handleConstraintViolationException(Exception ex, T request);

    Object handleInvalidFormatException(Exception ex, T request);

    Object handleIllegalArgumentException(Exception ex, T request);

    Object handleAuthorizationDeniedException(Exception ex, T request);

}
