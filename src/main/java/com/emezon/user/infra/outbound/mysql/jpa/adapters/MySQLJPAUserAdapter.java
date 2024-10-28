package com.emezon.user.infra.outbound.mysql.jpa.adapters;

import com.emezon.user.domain.models.User;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;
import com.emezon.user.infra.outbound.mysql.jpa.entities.UserEntity;
import com.emezon.user.infra.outbound.mysql.jpa.mappers.UserEntityMapper;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPAUserRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class MySQLJPAUserAdapter implements IUserRepositoryOutPort {

    private final IMySQLJPAUserRepository mySQLJPAUserRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntityMapper.toEntity(user);
        UserEntity savedUserEntity = mySQLJPAUserRepository.save(userEntity);
        return UserEntityMapper.toDomain(savedUserEntity);
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<UserEntity> userEntity = mySQLJPAUserRepository.findById(id);
        return userEntity.map(UserEntityMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userEntity = mySQLJPAUserRepository.findByEmail(email);
        return userEntity.map(UserEntityMapper::toDomain);
    }

    @Override
    public Boolean existsByEmail(String email) {
        Optional<UserEntity> userEntity = mySQLJPAUserRepository.findByEmail(email);
        return userEntity.isPresent();
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = mySQLJPAUserRepository.findAll();
        return userEntities.stream().map(UserEntityMapper::toDomain).toList();
    }
}
