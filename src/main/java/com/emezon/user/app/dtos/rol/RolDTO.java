package com.emezon.user.app.dtos.rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolDTO {
    private String id;
    private String name;
    private String description;

    public RolDTO(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public RolDTO() {
    }
}
