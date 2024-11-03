package com.emezon.user.app.mappers;

import com.emezon.user.app.dtos.user.CreateAdminDTO;
import com.emezon.user.app.dtos.user.CreateAuxBodegaDTO;
import com.emezon.user.app.dtos.user.CreateClientDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.domain.models.User;

public class UserMapper {

    private UserMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static User toModel(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setDocNumber(userDTO.getDocNumber());
        user.setCellphone(userDTO.getCellphone());
        user.setBirthdate(userDTO.getBirthdate());
        user.setEmail(userDTO.getEmail());
        if (userDTO.getRole() != null){
            user.setRole(RoleMapper.toModel(userDTO.getRole()));
        }
        return user;
    }

    public static User toModel(CreateAdminDTO createAdminDTO) {
        UserDTO userDTO = toUserDTO(createAdminDTO);
        User user = toModel(userDTO);
        user.setPassword(createAdminDTO.getPassword());
        return user;
    }

    public static User toModel(CreateAuxBodegaDTO createAuxBodegaDTO) {
        UserDTO userDTO = toUserDTO(createAuxBodegaDTO);
        User user = toModel(userDTO);
        user.setPassword(createAuxBodegaDTO.getPassword());
        return user;
    }

    public static User toModel(CreateClientDTO createClientDTO) {
        UserDTO userDTO = toUserDTO(createClientDTO);
        User user = toModel(userDTO);
        user.setPassword(createClientDTO.getPassword());
        return user;
    }

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDocNumber(user.getDocNumber());
        userDTO.setCellphone(user.getCellphone());
        userDTO.setBirthdate(user.getBirthdate());
        userDTO.setEmail(user.getEmail());
        if (user.getRole() != null) {
            userDTO.setRole(RoleMapper.toRolDTO(user.getRole()));
        }
        return userDTO;
    }

    public static UserDTO toUserDTO(CreateAdminDTO createAdminDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(createAdminDTO.getName());
        userDTO.setLastName(createAdminDTO.getLastName());
        userDTO.setDocNumber(createAdminDTO.getDocNumber());
        userDTO.setCellphone(createAdminDTO.getCellphone());
        userDTO.setBirthdate(createAdminDTO.getBirthdate());
        userDTO.setEmail(createAdminDTO.getEmail());
        return userDTO;
    }

    public static UserDTO toUserDTO(CreateAuxBodegaDTO createAuxBodegaDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(createAuxBodegaDTO.getName());
        userDTO.setLastName(createAuxBodegaDTO.getLastName());
        userDTO.setDocNumber(createAuxBodegaDTO.getDocNumber());
        userDTO.setCellphone(createAuxBodegaDTO.getCellphone());
        userDTO.setBirthdate(createAuxBodegaDTO.getBirthdate());
        userDTO.setEmail(createAuxBodegaDTO.getEmail());
        return userDTO;
    }

    public static UserDTO toUserDTO(CreateClientDTO createClientDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(createClientDTO.getName());
        userDTO.setLastName(createClientDTO.getLastName());
        userDTO.setDocNumber(createClientDTO.getDocNumber());
        userDTO.setCellphone(createClientDTO.getCellphone());
        userDTO.setBirthdate(createClientDTO.getBirthdate());
        userDTO.setEmail(createClientDTO.getEmail());
        return userDTO;
    }

}
