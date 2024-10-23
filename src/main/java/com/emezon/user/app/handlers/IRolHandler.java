package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.rol.RolDTO;

import java.util.List;

public interface IRolHandler {

    RolDTO getRolById(String id);

    RolDTO getRolByName(String name);

    List<RolDTO> getAllRoles();
}
