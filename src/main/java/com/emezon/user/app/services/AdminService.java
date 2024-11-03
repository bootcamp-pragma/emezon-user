package com.emezon.user.app.services;

import com.emezon.user.app.dtos.user.CreateAdminDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IAdminHandler;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.mappers.UserMapper;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.models.UserRoles;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdminService implements IAdminHandler {

    private final IUserHandler userHandler;


    @Override
    public UserDTO createAdmin(CreateAdminDTO createAdminDTO) {
        User user = UserMapper.toModel(createAdminDTO);
        Role ROLE_ADMIN = new Role();
        ROLE_ADMIN.setName(UserRoles.ADMIN.toString());
        user.setRole(ROLE_ADMIN);
        return userHandler.createUser(user);
    }

}
