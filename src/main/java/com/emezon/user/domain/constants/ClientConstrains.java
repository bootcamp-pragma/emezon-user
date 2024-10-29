package com.emezon.user.domain.constants;

import com.emezon.user.domain.models.User;

public class ClientConstrains {

    // Use general constrains
    // Restrictions exclusive to clients

    private ClientConstrains() {}

    public static User processAndValidate(User user) {
        // TODO: Implement processAndValidate
        // with the exclusive restrictions for clients
        return user;
    }

}
