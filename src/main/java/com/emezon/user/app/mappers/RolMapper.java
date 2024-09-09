package com.emezon.user.app.mappers;

import com.emezon.user.app.dtos.CreateRolDto;
import com.emezon.user.domain.models.Rol;

public class RolMapper {

    private RolMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Rol toModel(CreateRolDto createRolDto) {
        return new Rol(null, createRolDto.getName(), createRolDto.getDescription());
    }

    public static CreateRolDto toDto(Rol rol) {
        return new CreateRolDto(rol.getName(), rol.getDescription());
    }

}
