package com.emezon.user.domain.api;

import com.emezon.user.domain.models.User;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;

import java.util.Optional;

public interface IRetrieveUserInPort {

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    PaginatedResponse<User> findAll(PaginatedResponseParams params);

}
