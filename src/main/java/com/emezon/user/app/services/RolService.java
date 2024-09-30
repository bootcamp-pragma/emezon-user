package com.emezon.user.app.services;

import com.emezon.user.app.dtos.rol.CreateRolDto;
import com.emezon.user.app.dtos.rol.RolDTO;
import com.emezon.user.app.handlers.IRolHandler;
import com.emezon.user.app.mappers.RolMapper;
import com.emezon.user.domain.api.rol.IPersistRolInPort;
import com.emezon.user.domain.models.Rol;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RolService implements IRolHandler {

    private final IPersistRolInPort iPersistRolInPort;

    public RolDTO createRol(CreateRolDto rol) {
        Rol rolModel = iPersistRolInPort.createRol(RolMapper.toModel(rol));
        return RolMapper.toRolDTO(rolModel);
    }

}
