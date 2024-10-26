package com.emezon.user.app.mappers;

import com.emezon.user.app.dtos.role.CreateRoleDto;
import com.emezon.user.app.dtos.role.RoleDTO;
import com.emezon.user.domain.models.Role;

public class RoleMapper {

    private RoleMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Role toModel(RoleDTO roleDTO) {
        return new Role(roleDTO.getId(), roleDTO.getName(), roleDTO.getDescription());
    }

    public static CreateRoleDto toCreateRolDto(Role role) {
        return new CreateRoleDto(role.getName(), role.getDescription());
    }

    public static RoleDTO toRolDTO(Role role) {
        return new RoleDTO(role.getId(), role.getName(), role.getDescription());
    }

}
