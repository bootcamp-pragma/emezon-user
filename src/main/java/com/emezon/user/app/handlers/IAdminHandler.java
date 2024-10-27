package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.user.CreateAdminDTO;
import com.emezon.user.app.dtos.user.CreateAuxBodegaDTO;
import com.emezon.user.app.dtos.user.UserDTO;

public interface IAdminHandler {

    UserDTO createAdmin(CreateAdminDTO createAdminDTO);

    UserDTO createAuxBodega(CreateAuxBodegaDTO createAuxBodegaDTO);

}
