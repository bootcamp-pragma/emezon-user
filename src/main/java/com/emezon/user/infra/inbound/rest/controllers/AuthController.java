package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.app.dtos.auth.AuthRequest;
import com.emezon.user.app.dtos.auth.AuthResponse;
import com.emezon.user.app.dtos.user.CreateClientDTO;
import com.emezon.user.app.handlers.IAuthHandler;
import com.emezon.user.infra.inbound.rest.constants.RestApiConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(RestApiConstants.API_AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final IAuthHandler authHandler;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authHandler.signin(authRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody @Valid CreateClientDTO createClientDTO) {
        AuthResponse authResponse = authHandler.signup(createClientDTO);
        URI location = URI.create(RestApiConstants.API_AUTH + "/signup");
        return ResponseEntity.created(location).body(authResponse);
    }

}
