package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.app.dtos.rol.CreateRolDto;
import com.emezon.user.app.dtos.rol.RolDTO;
import com.emezon.user.app.handlers.IRolHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/rol")
@RequiredArgsConstructor
public class RolController {

    private final IRolHandler rolHandler;

    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody @Valid CreateRolDto createRolDto) {
        RolDTO createdRol = rolHandler.createRol(createRolDto);
        URI location = URI.create("/rol" + createdRol.getId());
        return ResponseEntity.created(location).body(createdRol);
    }

}
