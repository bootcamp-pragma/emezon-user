package com.emezon.user.domain.api.user;

import com.emezon.user.domain.models.User;

public interface IPersistUserInPort {

    User createUser(User user);

}
