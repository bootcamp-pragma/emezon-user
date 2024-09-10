package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.app.dtos.rol.CreateRolDto;
import com.emezon.user.app.dtos.rol.RolDTO;
import com.emezon.user.app.services.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;

    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody @Valid CreateRolDto createRolDto) {
        RolDTO createdRol = rolService.createRol(createRolDto);
        return ResponseEntity.ok(createdRol);
    }

}
