package com.emezon.user.infra.constants;

public class SecurityConstants {

    public static final String[] WHITE_LIST_URL = {
            "/api/docs/**",
            "/v3/api-docs/**",
            "/api/swagger-ui/**",
            RestApiConstants.API_AUTH + "/**",
    };

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_AUX_BODEGA = "AUX_BODEGA";
    public static final String ROLE_CLIENT = "CLIENT";

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHENTICATION_SCHEME = "Bearer ";

    public static final String ROLE_NAME_CLAIM = "roleName";

    private SecurityConstants() { }
}
