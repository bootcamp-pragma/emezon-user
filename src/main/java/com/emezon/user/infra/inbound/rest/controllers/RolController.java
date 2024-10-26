package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.app.dtos.role.RoleDTO;
import com.emezon.user.app.handlers.IRoleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@RequiredArgsConstructor
public class RolController {

    private final IRoleHandler rolHandler;

    @GetMapping()
    public ResponseEntity<List<RoleDTO>> getRoles() {
        return ResponseEntity.ok(rolHandler.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRolById(@PathVariable String id) {
        return ResponseEntity.ok(rolHandler.getRolById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RoleDTO> getRolByName(@PathVariable String name) {
        return ResponseEntity.ok(rolHandler.getRolByName(name));
    }

}
