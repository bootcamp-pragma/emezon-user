package com.emezon.user.app.services;

import com.emezon.user.app.dtos.user.CreateClientDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IClientHandler;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.mappers.UserMapper;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.models.UserRoles;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientService implements IClientHandler {

    private final IUserHandler userHandler;

    @Override
    public UserDTO createClient(CreateClientDTO createClientDTO) {
        User user = UserMapper.toModel(createClientDTO);
        Role ROLE_CLIENT = new Role();
        ROLE_CLIENT.setName(UserRoles.CLIENT.toString());
        user.setRole(ROLE_CLIENT);
        return userHandler.createUser(user);
    }

}
