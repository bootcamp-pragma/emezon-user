package com.emezon.user.domain.constants;

public class UserErrorMessages {

    public static final String USER_PARAM_REQUIRED = "User %s is required";
    public static final String USER_EMAIL_INVALID = "User email is invalid";
    public static final String USER_CELLPHONE_TOO_LONG = "User cellphone must be less than %d characters";
    public static final String USER_CELLPHONE_INVALID = "User cellphone must be a number and can have the + symbol at the beginning";
    public static final String USER_DOC_NUMBER_INVALID = "User document number must be a number";
    public static final String USER_TOO_YOUNG = "User must be at least %d years old";

    private UserErrorMessages() { }

}
