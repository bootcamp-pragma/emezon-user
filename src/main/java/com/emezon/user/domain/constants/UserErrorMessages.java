package com.emezon.user.domain.constants;

public class UserErrorMessages {

    public static final String USER_NAME_REQUIRED = "User name is required";
    public static final String USER_LASTNAME_REQUIRED = "User lastname is required";
    public static final String USER_DOC_NUMBER_REQUIRED = "User document number is required";
    public static final String USER_CELLPHONE_REQUIRED = "User cellphone is required";
    public static final String USER_BIRTHDATE_REQUIRED = "User birthdate is required";
    public static final String USER_EMAIL_REQUIRED = "User email is required";
    public static final String USER_PASSWORD_REQUIRED = "User password is required";
    public static final String USER_EMAIL_INVALID = "User email is invalid";
    public static final String USER_CELLPHONE_TOO_LONG = "User cellphone must be less than %d characters";
    public static final String USER_CELLPHONE_INVALID = "User cellphone must be a number and can have the + symbol at the beginning";
    public static final String USER_DOC_NUMBER_INVALID = "User document number must be a number";
    public static final String USER_BIRTHDATE_INVALID = "User birthdate is invalid";
    public static final String USER_TOO_YOUNG = "User must be at least %d years old";
    public static final String USER_EMAIL_ALREADY_EXISTS = "User with email '%s' already exists";

    private UserErrorMessages() { }

}
