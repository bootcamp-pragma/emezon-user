package com.emezon.user.domain.exceptions.rol;

import com.emezon.user.domain.constants.RolErrorMessages;

public class RolNameAlreadyExistsException extends RuntimeException {
    public RolNameAlreadyExistsException(String rolName) {
        super(String.format(RolErrorMessages.ROL_NAME_ALREADY_EXISTS, rolName));
    }
}
