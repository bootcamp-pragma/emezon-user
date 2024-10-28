package com.emezon.user.domain.exceptions.role;

import com.emezon.user.domain.constants.RoleErrorMessages;

public class RoleNameAlreadyExistsException extends RuntimeException {
    public RoleNameAlreadyExistsException(String rolName) {
        super(String.format(RoleErrorMessages.ROL_NAME_ALREADY_EXISTS, rolName));
    }
}
