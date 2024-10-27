package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.domain.models.User;

import java.util.List;

public interface IUserHandler {

    UserDTO createUser(User user);

    UserDTO getUserById(String id);

    UserDTO getUserByEmail(String email);

    List<UserDTO> getAllUsers();

}
