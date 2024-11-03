package com.emezon.user.app.handlers;


import com.emezon.user.app.dtos.user.CreateAuxBodegaDTO;
import com.emezon.user.app.dtos.user.UserDTO;

public interface IAuxBodegaHandler {

    UserDTO createAuxBodega(CreateAuxBodegaDTO createAuxBodegaDTO);

}
