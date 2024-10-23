package com.emezon.user.infra.outbound.mysql.jpa.mappers;

import com.emezon.user.domain.models.User;
import com.emezon.user.infra.outbound.mysql.jpa.entities.UserEntity;

public class UserEntityMapper {

    private UserEntityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .docNumber(user.getDocNumber())
                .cellphone(user.getCellphone())
                .birthdate(user.getBirthdate())
                .email(user.getEmail())
                .password(user.getPassword())
                .rol(RolEntityMapper.toEntity(user.getRol()))
                .build();
    }

    public static User toDomain(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        user.setDocNumber(userEntity.getDocNumber());
        user.setCellphone(userEntity.getCellphone());
        user.setBirthdate(userEntity.getBirthdate());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setRol(RolEntityMapper.toDomain(userEntity.getRol()));
        return user;
    }

}
