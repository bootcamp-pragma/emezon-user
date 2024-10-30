package com.emezon.user.domain.models;

public enum UserRoles {
    AUX_BODEGA("AUX_BODEGA"),
    ADMIN("ADMIN"),
    CLIENT("CLIENT");

    private final String roleName;

    UserRoles(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return this.roleName;
    }

}
