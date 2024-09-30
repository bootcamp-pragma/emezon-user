package com.emezon.user.infra.outbound.mysql.jpa.adapters;


import com.emezon.user.domain.models.Rol;
import com.emezon.user.domain.spi.IRolRepositoryOutPort;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RolEntity;
import com.emezon.user.infra.outbound.mysql.jpa.mappers.RolEntityMapper;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPARolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MySQLJPARolAdapter implements IRolRepositoryOutPort {

    private final IMySQLJPARolRepository mySQLJPARolRepository;

    @Override
    public Rol save(Rol rol) {
        RolEntity rolEntity = RolEntityMapper.toEntity(rol);
        RolEntity savedRolEntity = mySQLJPARolRepository.save(rolEntity);
        return RolEntityMapper.toDomain(savedRolEntity);
    }

    @Override
    public Optional<Rol> findById(String id) {
        Optional<RolEntity> rolEntity = mySQLJPARolRepository.findById(id);
        return rolEntity.map(RolEntityMapper::toDomain);
    }

    @Override
    public Optional<Rol> findByName(String name) {
        Optional<RolEntity> rolEntity = mySQLJPARolRepository.findByName(name);
        return rolEntity.map(RolEntityMapper::toDomain);
    }

    @Override
    public List<Rol> findAll() {
        List<RolEntity> rolEntities = mySQLJPARolRepository.findAll();
        return rolEntities.stream().map(RolEntityMapper::toDomain).toList();
    }
}
