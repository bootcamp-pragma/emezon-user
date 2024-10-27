package com.emezon.user.domain.usecases;

import com.emezon.user.domain.api.IPersistUserInPort;
import com.emezon.user.domain.constants.UserConstraints;
import com.emezon.user.domain.exceptions.user.UserEmailAlreadyExistsException;
import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.spi.IRoleRepositoryOutPort;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;
import com.emezon.user.domain.utils.IPasswordEncoder;

public class PersistUserUseCase implements IPersistUserInPort {

    private final IUserRepositoryOutPort userRepositoryOutPort;
    private final IPasswordEncoder passwordEncoder;
    private final IRoleRepositoryOutPort roleRepositoryOutPort;

    public PersistUserUseCase(IUserRepositoryOutPort userRepositoryOutPort, IPasswordEncoder passwordEncoder, IRoleRepositoryOutPort roleRepositoryOutPort) {
        this.userRepositoryOutPort = userRepositoryOutPort;
        this.passwordEncoder = passwordEncoder;
        this.roleRepositoryOutPort = roleRepositoryOutPort;
    }

    @Override
    public User createUser(User user) {
        User vuser = UserConstraints.processAndValidate(user);
        if (userRepositoryOutPort.existsByEmail(vuser.getEmail())) {
            throw new UserEmailAlreadyExistsException(vuser.getEmail());
        }
        Role role = vuser.getRole();
        if (role.getId() == null && role.getName() == null) {
            throw new IllegalArgumentException("Role must have an id or a name");
        }
        if (role.getId() != null) {
            role = roleRepositoryOutPort.findById(role.getId()).orElseThrow(
                    () -> new IllegalArgumentException("Role not found by id"));
        } else {
            role = roleRepositoryOutPort.findByName(role.getName()).orElseThrow(
                    () -> new IllegalArgumentException("Role not found by name"));
        }
        vuser.setRole(role);
        vuser.setPassword(passwordEncoder.encode(vuser.getPassword()));
        return userRepositoryOutPort.save(vuser);
    }
}
