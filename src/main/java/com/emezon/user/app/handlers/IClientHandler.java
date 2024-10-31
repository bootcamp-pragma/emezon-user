package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.user.CreateClientDTO;
import com.emezon.user.app.dtos.user.UserDTO;

public interface IClientHandler {

    UserDTO createClient(CreateClientDTO createClientDTO);

}
