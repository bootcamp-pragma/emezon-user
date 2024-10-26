package com.emezon.user.domain.usecases;

import com.emezon.user.domain.api.IRetrieveRoleInPort;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.spi.IRolRepositoryOutPort;

import java.util.List;
import java.util.Optional;

public class RetrieveRoleUseCase implements IRetrieveRoleInPort {

    private final IRolRepositoryOutPort rolRepositoryOutPort;

    public RetrieveRoleUseCase(IRolRepositoryOutPort rolRepositoryOutPort) {
        this.rolRepositoryOutPort = rolRepositoryOutPort;
    }

    @Override
    public Optional<Role> findById(String id) {
        return rolRepositoryOutPort.findById(id);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return rolRepositoryOutPort.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return rolRepositoryOutPort.findAll();
    }
}
