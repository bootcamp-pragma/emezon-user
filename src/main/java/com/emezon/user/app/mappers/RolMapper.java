package com.emezon.user.app.mappers;

import com.emezon.user.app.dtos.rol.CreateRolDto;
import com.emezon.user.app.dtos.rol.RolDTO;
import com.emezon.user.domain.models.Rol;

public class RolMapper {

    private RolMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Rol toModel(CreateRolDto createRolDto) {
        return new Rol(null, createRolDto.getName(), createRolDto.getDescription());
    }

    public static CreateRolDto toCreateRolDto(Rol rol) {
        return new CreateRolDto(rol.getName(), rol.getDescription());
    }

    public static RolDTO toRolDTO(Rol rol) {
        return new RolDTO(rol.getId(), rol.getName(), rol.getDescription());
    }

}
