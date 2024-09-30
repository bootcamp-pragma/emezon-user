package com.emezon.user.infra.outbound.mysql.jpa.mappers;

import com.emezon.user.app.dtos.rol.CreateRolDto;
import com.emezon.user.domain.models.Rol;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RolEntity;

public class RolEntityMapper {

    private RolEntityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static RolEntity toEntity(Rol rol) {
        return RolEntity.builder()
                .id(rol.getId())
                .name(rol.getName())
                .description(rol.getDescription())
                .build();
    }

    public static RolEntity toEntity(CreateRolDto createRolDto) {
        return RolEntity.builder()
                .name(createRolDto.getName())
                .description(createRolDto.getDescription())
                .build();
    }

    public static Rol toDomain(RolEntity rolEntity) {
        return new Rol(rolEntity.getId(), rolEntity.getName(), rolEntity.getDescription());
    }

    public static CreateRolDto toCreateRolDto(RolEntity rolEntity) {
        return new CreateRolDto(rolEntity.getName(), rolEntity.getDescription());
    }

}
