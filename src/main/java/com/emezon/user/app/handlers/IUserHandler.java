package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.utils.PaginatedResponse;
import org.springframework.util.MultiValueMap;

public interface IUserHandler {

    UserDTO createUser(User user);

    UserDTO getUserById(String id);

    UserDTO getUserByEmail(String email);

    PaginatedResponse<UserDTO> getAllUsers(MultiValueMap<String, String> queryParams);

}
