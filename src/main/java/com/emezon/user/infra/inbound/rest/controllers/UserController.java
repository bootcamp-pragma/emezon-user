package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.infra.inbound.rest.constants.RestApiConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestApiConstants.API_USER)
@RequiredArgsConstructor
public class UserController {

    private final IUserHandler userHandler;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userHandler.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userHandler.getUserByEmail(email));
    }

}
