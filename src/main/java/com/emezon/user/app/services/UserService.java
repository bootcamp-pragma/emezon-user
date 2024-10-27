package com.emezon.user.app.services;

import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.mappers.UserMapper;
import com.emezon.user.domain.api.IPersistUserInPort;
import com.emezon.user.domain.api.IRetrieveUserInPort;
import com.emezon.user.domain.models.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserService implements IUserHandler {

    private final IRetrieveUserInPort retrieveUserInPort;
    private final IPersistUserInPort persistUserInPort;

    @Override
    public UserDTO createUser(User user) {
        User userCreated = persistUserInPort.createUser(user);
        return UserMapper.toUserDTO(userCreated);
    }

    @Override
    public UserDTO getUserById(String id) {
        Optional<User> user = retrieveUserInPort.findById(id);
        return user.map(UserMapper::toUserDTO).orElse(null);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        Optional<User> user = retrieveUserInPort.findByEmail(email);
        return user.map(UserMapper::toUserDTO).orElse(null);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = retrieveUserInPort.findAll();
        return users.stream().map(UserMapper::toUserDTO).toList();
    }
}
