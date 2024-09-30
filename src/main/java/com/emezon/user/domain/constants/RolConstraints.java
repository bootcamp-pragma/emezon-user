package com.emezon.user.domain.constants;

public class RolConstraints {

    public static final String ADMIN = "admin";
    public static final String AUX_BODEGA = "aux_bodega";
    public static final int ROL_NAME_MAX_LENGTH = 25;
    public static final int ROL_DESCRIPTION_MAX_LENGTH = 100;

    private RolConstraints() {
        throw new IllegalStateException("Utility class");
    }

}
