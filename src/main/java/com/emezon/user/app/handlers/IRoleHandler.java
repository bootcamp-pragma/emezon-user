package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.role.RoleDTO;

import java.util.List;

public interface IRoleHandler {

    RoleDTO getRolById(String id);

    RoleDTO getRolByName(String name);

    List<RoleDTO> getAllRoles();
}
