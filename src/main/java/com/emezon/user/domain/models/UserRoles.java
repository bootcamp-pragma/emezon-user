package com.emezon.user.domain.models;

public enum UserRoles {
    AUX_BODEGA("ROLE_AUX_BODEGA"),
    ADMIN("ROLE_ADMIN"),
    CLIENT("ROLE_CLIENT");

    private final String roleName;

    UserRoles(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return this.roleName;
    }

}
