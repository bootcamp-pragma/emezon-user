package com.emezon.user.domain.usecases;

import com.emezon.user.domain.api.IRetrieveUserInPort;
import com.emezon.user.domain.constants.PaginatedResponseConstraints;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;

import java.util.Optional;

public class RetrieveUserUseCase implements IRetrieveUserInPort {

    private final IUserRepositoryOutPort userRepositoryOutPort;

    public RetrieveUserUseCase(IUserRepositoryOutPort userRepositoryOutPort) {
        this.userRepositoryOutPort = userRepositoryOutPort;
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepositoryOutPort.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepositoryOutPort.findByEmail(email);
    }

    @Override
    public PaginatedResponse<User> findAll(PaginatedResponseParams params) {
        PaginatedResponseConstraints.validateParameters(params);
        return userRepositoryOutPort.findAll(params);
    }

}
