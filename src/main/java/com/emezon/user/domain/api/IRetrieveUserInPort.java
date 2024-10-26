package com.emezon.user.domain.api;

import com.emezon.user.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface IRetrieveUserInPort {

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

}
