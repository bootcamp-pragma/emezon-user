package com.emezon.user.domain.spi;

import com.emezon.user.domain.models.User;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;

import java.util.Optional;

public interface IUserRepositoryOutPort {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    PaginatedResponse<User> findAll(PaginatedResponseParams params);

}
