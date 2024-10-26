package com.emezon.user.infra.outbound.mysql.jpa.mappers;

import com.emezon.user.app.dtos.role.CreateRoleDto;
import com.emezon.user.domain.models.Role;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RoleEntity;

public class RolEntityMapper {

    private RolEntityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static RoleEntity toEntity(Role role) {
        return RoleEntity.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public static RoleEntity toEntity(CreateRoleDto createRoleDto) {
        return RoleEntity.builder()
                .name(createRoleDto.getName())
                .description(createRoleDto.getDescription())
                .build();
    }

    public static Role toDomain(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(), roleEntity.getName(), roleEntity.getDescription());
    }

    public static CreateRoleDto toCreateRolDto(RoleEntity roleEntity) {
        return new CreateRoleDto(roleEntity.getName(), roleEntity.getDescription());
    }

}
