package com.emezon.user.app.services;

import com.emezon.user.app.dtos.rol.CreateRolDto;
import com.emezon.user.app.dtos.rol.RolDTO;
import com.emezon.user.app.mappers.RolMapper;
import com.emezon.user.domain.models.Rol;
import com.emezon.user.domain.usecases.PersistRolUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RolService {

    private final PersistRolUseCase persistRolUseCase;

    public RolDTO createRol(CreateRolDto rol) {
        Rol rolModel = persistRolUseCase.createRol(RolMapper.toModel(rol));
        return RolMapper.toRolDTO(rolModel);
    }

}
