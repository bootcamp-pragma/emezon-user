package com.emezon.user.domain.usecases;

import com.emezon.user.domain.exceptions.rol.RolNameAlreadyExistsException;
import com.emezon.user.domain.models.Rol;
import com.emezon.user.domain.ports.inbound.rol.IPersistRolInPort;
import com.emezon.user.domain.ports.outbound.IRolRepositoryOutPort;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPARolRepository;

import java.util.Optional;

public class PersistRolUseCase implements IPersistRolInPort {

    private final IRolRepositoryOutPort rolRepositoryOutPort;

    public PersistRolUseCase(IRolRepositoryOutPort rolRepositoryOutPort) {
        this.rolRepositoryOutPort = rolRepositoryOutPort;
    }

    @Override
    public Rol createRol(Rol rol) {
        Optional<Rol> rolByName = rolRepositoryOutPort.findByName(rol.getName());
        if (rolByName.isPresent()) {
            throw new RolNameAlreadyExistsException(rol.getName());
        }
        return rolRepositoryOutPort.save(rol);
    }

}
