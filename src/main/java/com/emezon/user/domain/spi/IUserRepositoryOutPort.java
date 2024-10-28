package com.emezon.user.domain.spi;

import com.emezon.user.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepositoryOutPort {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    List<User> findAll();

}
