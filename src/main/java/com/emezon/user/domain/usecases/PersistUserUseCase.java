package com.emezon.user.domain.usecases;

import com.emezon.user.domain.api.IPersistUserInPort;
import com.emezon.user.domain.constants.UserConstraints;
import com.emezon.user.domain.exceptions.user.UserEmailAlreadyExistsException;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;
import com.emezon.user.domain.utils.IPasswordEncoder;

public class PersistUserUseCase implements IPersistUserInPort {

    private final IUserRepositoryOutPort userRepositoryOutPort;
    private final IPasswordEncoder passwordEncoder;

    public PersistUserUseCase(IUserRepositoryOutPort userRepositoryOutPort, IPasswordEncoder passwordEncoder) {
        this.userRepositoryOutPort = userRepositoryOutPort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(User user) {
        User vuser = UserConstraints.processAndValidate(user);
        if (userRepositoryOutPort.existsByEmail(vuser.getEmail())) {
            throw new UserEmailAlreadyExistsException(vuser.getEmail());
        }
        vuser.setPassword(passwordEncoder.encode(vuser.getPassword()));
        return userRepositoryOutPort.save(vuser);
    }
}
