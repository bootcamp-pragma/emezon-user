package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.user.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserHandler {

    UserDTO getUserById(String id);

    UserDTO getUserByEmail(String email);

    List<UserDTO> getAllUsers();

}
