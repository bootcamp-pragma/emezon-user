package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.app.dtos.rol.RolDTO;
import com.emezon.user.app.handlers.IRolHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@RequiredArgsConstructor
public class RolController {

    private final IRolHandler rolHandler;

    @GetMapping()
    public ResponseEntity<List<RolDTO>> getRoles() {
        return ResponseEntity.ok(rolHandler.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable String id) {
        return ResponseEntity.ok(rolHandler.getRolById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RolDTO> getRolByName(@PathVariable String name) {
        return ResponseEntity.ok(rolHandler.getRolByName(name));
    }

}
