package com.emezon.user.domain.spi;

import com.emezon.user.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolRepositoryOutPort {

    Rol save(Rol rol);

    Optional<Rol> findById(String id);

    Optional<Rol> findByName(String name);

    List<Rol> findAll();

}
