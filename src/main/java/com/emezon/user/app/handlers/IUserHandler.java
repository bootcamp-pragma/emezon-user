package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.user.UserDTO;

import java.util.Optional;

public interface IUserHandler {

    Optional<UserDTO> getUserById(String id);

    Optional<UserDTO> getUserByEmail(String email);

}
