package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.auth.AuthRequest;
import com.emezon.user.app.dtos.auth.AuthResponse;

public interface IAuthHandler {

    AuthResponse signin(AuthRequest request);

    AuthResponse signup(AuthRequest request);

}
