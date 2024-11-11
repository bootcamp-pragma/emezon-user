package com.emezon.user.app.services;

import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.mappers.UserMapper;
import com.emezon.user.domain.api.IPersistUserInPort;
import com.emezon.user.domain.api.IRetrieveUserInPort;
import com.emezon.user.domain.models.User;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;
import com.emezon.user.domain.utils.PaginatedResponseUtils;
import lombok.AllArgsConstructor;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserService implements IUserHandler {

    private final IRetrieveUserInPort retrieveUserInPort;
    private final IPersistUserInPort persistUserInPort;

    @Override
    public UserDTO createUser(User user) {
        User userCreated = persistUserInPort.createUser(user);
        return UserMapper.toUserDTO(userCreated);
    }

    @Override
    public UserDTO getUserById(String id) {
        Optional<User> user = retrieveUserInPort.findById(id);
        return user.map(UserMapper::toUserDTO).orElse(null);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        Optional<User> user = retrieveUserInPort.findByEmail(email);
        return user.map(UserMapper::toUserDTO).orElse(null);
    }

    @Override
    public PaginatedResponse<UserDTO> getAllUsers(MultiValueMap<String, String> queryParams) {
        PaginatedResponseParams params = PaginatedResponseUtils.getFromMap(queryParams);
        PaginatedResponse<User> users = retrieveUserInPort.findAll(params);
        List<UserDTO> userDTOS = users.getItems().stream().map(UserMapper::toUserDTO).toList();
        return new PaginatedResponse<>(
                userDTOS,
                users.getPage(),
                users.getSize(),
                users.getTotalItems(),
                users.getTotalPages()
        );
    }
}
