package com.emezon.user.app.services;

import com.emezon.user.app.dtos.user.CreateAuxBodegaDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IAuxBodegaHandler;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.mappers.UserMapper;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.models.UserRoles;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuxBodegaService implements IAuxBodegaHandler {

    private final IUserHandler userHandler;

    @Override
    public UserDTO createAuxBodega(CreateAuxBodegaDTO createAuxBodegaDTO) {
        User user = UserMapper.toModel(createAuxBodegaDTO);
        Role ROLE_AUX_BODEGA = new Role();
        ROLE_AUX_BODEGA.setName(UserRoles.AUX_BODEGA.toString());
        user.setRole(ROLE_AUX_BODEGA);
        return userHandler.createUser(user);
    }

}
