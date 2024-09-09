package com.emezon.user.domain.ports.inbound.rol;

import com.emezon.user.domain.models.Rol;

public interface IPersistRolInPort {

    Rol createRol(Rol rol);

    Rol updateRol(Rol rol);

}
