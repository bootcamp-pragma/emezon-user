package com.emezon.user.infra.outbound.mysql.jpa.mappers;

import com.emezon.user.app.dtos.CreateRolDto;
import com.emezon.user.domain.models.Rol;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RolEntity;

public class RolEntityMapper {

    private RolEntityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static RolEntity toEntity(Rol rol) {
        return new RolEntity(rol.getId(), rol.getName(), rol.getDescription());
    }

    public static RolEntity toEntity(CreateRolDto createRolDto) {
        return new RolEntity(null, createRolDto.getName(), createRolDto.getDescription());
    }

    public static Rol toDomain(RolEntity rolEntity) {
        return new Rol(rolEntity.getId(), rolEntity.getName(), rolEntity.getDescription());
    }

    public static CreateRolDto toCreateRolDto(RolEntity rolEntity) {
        return new CreateRolDto(rolEntity.getName(), rolEntity.getDescription());
    }

}
