package com.emezon.user.domain.api.rol;

import com.emezon.user.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface IRetrieveRolInPort {

    Optional<Rol> findById(String id);

    Optional<Rol> findByName(String name);

    List<Rol> findAll();

}
