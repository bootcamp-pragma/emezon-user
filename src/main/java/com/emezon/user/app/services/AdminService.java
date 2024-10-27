package com.emezon.user.app.services;

import com.emezon.user.app.dtos.role.RoleDTO;
import com.emezon.user.app.dtos.user.CreateAdminDTO;
import com.emezon.user.app.dtos.user.CreateAuxBodegaDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IAdminHandler;
import com.emezon.user.app.handlers.IRoleHandler;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.mappers.RoleMapper;
import com.emezon.user.app.mappers.UserMapper;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.models.UserRoles;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdminService implements IAdminHandler {

    private final IUserHandler userHandler;
    private final IRoleHandler roleHandler;


    @Override
    public UserDTO createAdmin(CreateAdminDTO createAdminDTO) {
        User user = UserMapper.toModel(createAdminDTO);
        RoleDTO ROLE_ADMIN = roleHandler.getRolByName(UserRoles.ROLE_ADMIN.name());
        if (ROLE_ADMIN == null) {
            throw new RuntimeException("Role Admin not found");
        }
        user.setRole(RoleMapper.toModel(ROLE_ADMIN));
        return userHandler.createUser(user);
    }

    @Override
    public UserDTO createAuxBodega(CreateAuxBodegaDTO createAuxBodegaDTO) {
        User user = UserMapper.toModel(createAuxBodegaDTO);
        RoleDTO ROLE_AUX_BODEGA = roleHandler.getRolByName(UserRoles.ROLE_AUX_BODEGA.name());
        if (ROLE_AUX_BODEGA == null) {
            throw new RuntimeException("Role Aux Bodega not found");
        }
        user.setRole(RoleMapper.toModel(ROLE_AUX_BODEGA));
        return userHandler.createUser(user);
    }
}
