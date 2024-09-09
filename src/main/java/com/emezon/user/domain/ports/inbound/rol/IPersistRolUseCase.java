package com.emezon.user.domain.ports.inbound.rol;

import com.emezon.user.domain.models.Rol;

public interface IPersistRolUseCase {

    Rol createRol(Rol rol);

    Rol updateRol(Rol rol);

}
