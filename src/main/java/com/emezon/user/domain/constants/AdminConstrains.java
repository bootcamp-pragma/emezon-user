package com.emezon.user.domain.constants;

import com.emezon.user.domain.models.User;

public class AdminConstrains {

    // Use general constrains
    // Restrictions exclusive to administrators

    private AdminConstrains() {}

    public static User processAndValidate(User user) {
        // TODO: Implement processAndValidate
        // with the exclusive restrictions for administrators
        return user;
    }

}
