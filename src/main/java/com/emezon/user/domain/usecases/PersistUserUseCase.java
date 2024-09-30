package com.emezon.user.domain.usecases;

import com.emezon.user.domain.api.user.IPersistUserInPort;
import com.emezon.user.domain.constants.UserConstraints;
import com.emezon.user.domain.exceptions.user.UserEmailAlreadyExistsException;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;

import java.util.Optional;

public class PersistUserUseCase implements IPersistUserInPort {

    private final IUserRepositoryOutPort userRepositoryOutPort;

    public PersistUserUseCase(IUserRepositoryOutPort userRepositoryOutPort) {
        this.userRepositoryOutPort = userRepositoryOutPort;
    }

    @Override
    public User createUser(User user) {
        User vuser = UserConstraints.processAndValidate(user);
        Optional<User> userByEmail = userRepositoryOutPort.findByEmail(vuser.getEmail());
        if (userByEmail.isPresent()) {
            throw new UserEmailAlreadyExistsException(vuser.getEmail());
        }
        // TODO: Encrypt password
        return userRepositoryOutPort.save(vuser);
    }
}
