package com.emezon.user.infra.outbound.mysql.jpa.adapters;

import com.emezon.user.domain.models.User;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;
import com.emezon.user.infra.outbound.mysql.jpa.entities.UserEntity;
import com.emezon.user.infra.outbound.mysql.jpa.mappers.UserEntityMapper;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPAUserRepository;
import com.emezon.user.infra.outbound.mysql.jpa.utils.PageableUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@AllArgsConstructor
public class MySQLJPAUserAdapter implements IUserRepositoryOutPort {

    private final IMySQLJPAUserRepository repository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntityMapper.toEntity(user);
        UserEntity savedUserEntity = repository.save(userEntity);
        return UserEntityMapper.toDomain(savedUserEntity);
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<UserEntity> userEntity = repository.findById(id);
        return userEntity.map(UserEntityMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userEntity = repository.findByEmail(email);
        return userEntity.map(UserEntityMapper::toDomain);
    }

    @Override
    public Boolean existsByEmail(String email) {
        Optional<UserEntity> userEntity = repository.findByEmail(email);
        return userEntity.isPresent();
    }

    @Override
    public PaginatedResponse<User> findAll(PaginatedResponseParams params) {
        Pageable pageable = PageableUtils.getFromPaginatedResponseParams(params);
        Page<UserEntity> pageRes = repository.findAll(pageable);
        PaginatedResponse<User> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setItems(pageRes.getContent().stream().map(UserEntityMapper::toDomain).toList());
        paginatedResponse.setTotalItems(pageRes.getTotalElements());
        paginatedResponse.setTotalPages(pageRes.getTotalPages());
        paginatedResponse.setPage(pageRes.getNumber());
        paginatedResponse.setSize(pageRes.getSize());
        return paginatedResponse;
    }
}
