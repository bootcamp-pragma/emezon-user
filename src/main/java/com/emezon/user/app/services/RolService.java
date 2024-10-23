package com.emezon.user.app.services;

import com.emezon.user.app.dtos.rol.RolDTO;
import com.emezon.user.app.handlers.IRolHandler;
import com.emezon.user.app.mappers.RolMapper;
import com.emezon.user.domain.api.rol.IRetrieveRolInPort;
import com.emezon.user.domain.models.Rol;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RolService implements IRolHandler {

    private final IRetrieveRolInPort retrieveRolInPort;

    @Override
    public RolDTO getRolById(String id) {
        Optional<Rol> rol = retrieveRolInPort.findById(id);
        return rol.map(RolMapper::toRolDTO).orElse(null);
    }

    @Override
    public RolDTO getRolByName(String name) {
        Optional<Rol> rol = retrieveRolInPort.findByName(name);
        return rol.map(RolMapper::toRolDTO).orElse(null);
    }

    @Override
    public List<RolDTO> getAllRoles() {
        List<Rol> roles = retrieveRolInPort.findAll();
        return roles.stream().map(RolMapper::toRolDTO).toList();
    }
}
