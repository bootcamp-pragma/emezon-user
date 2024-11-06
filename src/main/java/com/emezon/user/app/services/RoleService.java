package com.emezon.user.app.services;

import com.emezon.user.app.dtos.role.RoleDTO;
import com.emezon.user.app.handlers.IRoleHandler;
import com.emezon.user.app.mappers.RoleMapper;
import com.emezon.user.domain.api.IRetrieveRoleInPort;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;
import com.emezon.user.domain.utils.PaginatedResponseUtils;
import lombok.AllArgsConstructor;
import org.springframework.util.MultiValueMap;

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
    public PaginatedResponse<RoleDTO> getAllRoles(MultiValueMap<String, String> queryParams) {
        PaginatedResponseParams params = PaginatedResponseUtils.getFromMap(queryParams);
        PaginatedResponse<Role> roles = retrieveRolInPort.findAll(params);
        List<RoleDTO> roleDTOS = roles.getItems().stream().map(RoleMapper::toRolDTO).toList();
        return new PaginatedResponse<>(
                roleDTOS,
                roles.getPage(),
                roles.getSize(),
                roles.getTotalItems(),
                roles.getTotalPages()
        );
    }
}
