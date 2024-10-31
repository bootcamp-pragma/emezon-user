package com.emezon.user.domain.models;

public enum UserRoles {
    AUX_BODEGA("aux_bodega"),
    ADMIN("admin"),
    CLIENT("client");

    private final String name;

    UserRoles(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
