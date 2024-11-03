package com.emezon.user.domain.usecases;

import com.emezon.user.domain.api.IRetrieveRoleInPort;
import com.emezon.user.domain.constants.PaginatedResponseConstraints;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.spi.IRoleRepositoryOutPort;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;

import java.util.Optional;

public class RetrieveRoleUseCase implements IRetrieveRoleInPort {

    private final IRoleRepositoryOutPort rolRepositoryOutPort;

    public RetrieveRoleUseCase(IRoleRepositoryOutPort rolRepositoryOutPort) {
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
    public PaginatedResponse<Role> findAll(PaginatedResponseParams params) {
        PaginatedResponseConstraints.validateParameters(params);
        return rolRepositoryOutPort.findAll(params);
    }

}
