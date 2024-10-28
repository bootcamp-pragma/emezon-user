package com.emezon.user.infra.outbound.mysql.jpa.adapters;


import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.spi.IRoleRepositoryOutPort;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RoleEntity;
import com.emezon.user.infra.outbound.mysql.jpa.mappers.RolEntityMapper;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPARolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MySQLJPARoleAdapter implements IRoleRepositoryOutPort {

    private final IMySQLJPARolRepository mySQLJPARolRepository;

    @Override
    public Optional<Role> findById(String id) {
        Optional<RoleEntity> rolEntity = mySQLJPARolRepository.findById(id);
        return rolEntity.map(RolEntityMapper::toDomain);
    }

    @Override
    public Optional<Role> findByName(String name) {
        Optional<RoleEntity> rolEntity = mySQLJPARolRepository.findByName(name);
        return rolEntity.map(RolEntityMapper::toDomain);
    }

    @Override
    public List<Role> findAll() {
        List<RoleEntity> rolEntities = mySQLJPARolRepository.findAll();
        return rolEntities.stream().map(RolEntityMapper::toDomain).toList();
    }
}
