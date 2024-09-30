package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.rol.CreateRolDto;
import com.emezon.user.app.dtos.rol.RolDTO;

public interface IRolHandler {

    RolDTO createRol(CreateRolDto createRolDto);

}
