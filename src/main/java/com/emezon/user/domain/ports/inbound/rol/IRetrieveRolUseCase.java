package com.emezon.user.domain.ports.inbound.rol;

import com.emezon.user.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface IRetrieveRolUseCase {

    Optional<Rol> findById(String id);

    Optional<Rol> findByName(String name);

    List<Rol> findAll(int page, int size, List<String> sorting);

}
