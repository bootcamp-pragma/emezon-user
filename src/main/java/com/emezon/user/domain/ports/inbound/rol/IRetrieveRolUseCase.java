package com.emezon.user.domain.ports.inbound.rol;

import com.emezon.user.domain.models.Rol;

import java.util.Optional;

public interface IRetrieveRolUseCase {

    Optional<Rol> findById(String id);

    Optional<Rol> findByName(String name);

}
