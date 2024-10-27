package com.emezon.user.app.services;

import com.emezon.user.app.dtos.user.CreateAdminDTO;
import com.emezon.user.app.dtos.user.CreateAuxBodegaDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IAdminHandler;
import com.emezon.user.app.handlers.IRoleHandler;
import com.emezon.user.app.handlers.IUserHandler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdminService implements IAdminHandler {

    private final IUserHandler userHandler;
    private final IRoleHandler roleHandler;


    @Override
    public UserDTO createAdmin(CreateAdminDTO createAdminDTO) {
        return null;
    }

    @Override
    public UserDTO createAuxBodega(CreateAuxBodegaDTO createAuxBodegaDTO) {
        return null;
    }
}
