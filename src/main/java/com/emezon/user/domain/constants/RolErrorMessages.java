package com.emezon.user.domain.constants;

public class RolErrorMessages {

    public static final String ROL_NAME_REQUIRED = "Rol name is required";
    public static final String ROL_DESCRIPTION_REQUIRED = "Rol description is required";
    public static final String ROL_NAME_TOO_LONG = "Rol name must be less than %d characters";
    public static final String ROL_DESCRIPTION_TOO_LONG = "Rol description must be less than %d characters";
    public static final String ROL_NAME_ALREADY_EXISTS = "Rol with name '%s' already exists";

    private RolErrorMessages() {
        throw new IllegalStateException("Utility class");
    }

}
