package com.emezon.user.domain.usecases;

import com.emezon.user.domain.api.rol.IRetrieveRolInPort;
import com.emezon.user.domain.models.Rol;
import com.emezon.user.domain.spi.IRolRepositoryOutPort;

import java.util.List;
import java.util.Optional;

public class RetrieveRolUseCase implements IRetrieveRolInPort {

    private final IRolRepositoryOutPort rolRepositoryOutPort;

    public RetrieveRolUseCase(IRolRepositoryOutPort rolRepositoryOutPort) {
        this.rolRepositoryOutPort = rolRepositoryOutPort;
    }

    @Override
    public Optional<Rol> findById(String id) {
        return rolRepositoryOutPort.findById(id);
    }

    @Override
    public Optional<Rol> findByName(String name) {
        return rolRepositoryOutPort.findByName(name);
    }

    @Override
    public List<Rol> findAll() {
        return rolRepositoryOutPort.findAll();
    }
}
