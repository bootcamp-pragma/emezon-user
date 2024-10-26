package com.emezon.user.domain.api;

import com.emezon.user.domain.models.User;

public interface IPersistUserInPort {

    User createUser(User user);

}
