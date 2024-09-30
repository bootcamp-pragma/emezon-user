package com.emezon.user.domain.exceptions.user;

import com.emezon.user.domain.constants.UserErrorMessages;

public class UserEmailAlreadyExistsException extends RuntimeException {
    public UserEmailAlreadyExistsException(String email) {
        super(String.format(UserErrorMessages.USER_EMAIL_ALREADY_EXISTS, email));
    }
}
