package com.emezon.user.app.services;

import com.emezon.user.app.dtos.role.RoleDTO;
import com.emezon.user.app.handlers.IRoleHandler;
import com.emezon.user.app.mappers.RoleMapper;
import com.emezon.user.domain.api.IRetrieveRoleInPort;
import com.emezon.user.domain.models.Role;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RoleService implements IRoleHandler {

    private final IRetrieveRoleInPort retrieveRolInPort;

    @Override
    public RoleDTO getRolById(String id) {
        Optional<Role> rol = retrieveRolInPort.findById(id);
        return rol.map(RoleMapper::toRolDTO).orElse(null);
    }

    @Override
    public RoleDTO getRolByName(String name) {
        Optional<Role> rol = retrieveRolInPort.findByName(name);
        return rol.map(RoleMapper::toRolDTO).orElse(null);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<Role> roles = retrieveRolInPort.findAll();
        return roles.stream().map(RoleMapper::toRolDTO).toList();
    }
}
