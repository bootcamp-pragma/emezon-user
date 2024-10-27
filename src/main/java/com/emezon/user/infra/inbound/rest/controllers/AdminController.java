package com.emezon.user.infra.inbound.rest.controllers;


import com.emezon.user.app.dtos.user.CreateAdminDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IAdminHandler;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.infra.constants.RestApiConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(RestApiConstants.API_ADMIN)
@RequiredArgsConstructor
public class AdminController {

    private final IUserHandler userHandler;
    private final IAdminHandler adminHandler;

    @PostMapping()
    public ResponseEntity<UserDTO> addNewAdmin(
            @RequestBody @Valid CreateAdminDTO createAdminDTO) {
        URI location = URI.create(RestApiConstants.API_ADMIN + "/");
        UserDTO createdUser = adminHandler.createAdmin(createAdminDTO);
        return ResponseEntity.created(location).body(createdUser);
    }

}
