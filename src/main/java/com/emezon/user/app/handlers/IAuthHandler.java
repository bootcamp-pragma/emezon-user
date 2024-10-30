package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.auth.AuthRequest;
import com.emezon.user.app.dtos.auth.AuthResponse;
import com.emezon.user.app.dtos.user.CreateClientDTO;

public interface IAuthHandler {

    AuthResponse signin(AuthRequest request);

    AuthResponse signup(CreateClientDTO clientDTO);

}
