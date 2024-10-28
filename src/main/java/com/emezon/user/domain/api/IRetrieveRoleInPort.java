package com.emezon.user.domain.api;

import com.emezon.user.domain.models.Role;

import java.util.List;
import java.util.Optional;

public interface IRetrieveRoleInPort {

    Optional<Role> findById(String id);

    Optional<Role> findByName(String name);

    List<Role> findAll();

}
