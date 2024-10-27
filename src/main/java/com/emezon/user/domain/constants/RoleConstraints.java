package com.emezon.user.domain.constants;

public class RoleConstraints {

    public static final int ROL_NAME_MAX_LENGTH = 25;
    public static final int ROL_DESCRIPTION_MAX_LENGTH = 100;

    private RoleConstraints() {
        throw new IllegalStateException("Utility class");
    }

}
