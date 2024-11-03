package com.emezon.user.domain.api;

import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;

import java.util.Optional;

public interface IRetrieveRoleInPort {

    Optional<Role> findById(String id);

    Optional<Role> findByName(String name);

    PaginatedResponse<Role> findAll(PaginatedResponseParams params);

}
