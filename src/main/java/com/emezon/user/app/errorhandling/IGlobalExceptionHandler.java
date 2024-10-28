package com.emezon.user.app.errorhandling;

public interface IGlobalExceptionHandler<T> {

    Object handleGeneralException(Exception ex, T request);

}
