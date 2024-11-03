package com.emezon.user.infra.outbound.mysql.jpa.adapters;


import com.emezon.user.domain.models.Role;
import com.emezon.user.domain.spi.IRoleRepositoryOutPort;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.domain.utils.PaginatedResponseParams;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RoleEntity;
import com.emezon.user.infra.outbound.mysql.jpa.mappers.RolEntityMapper;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPARolRepository;
import com.emezon.user.infra.outbound.mysql.jpa.utils.PageableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class MySQLJPARoleAdapter implements IRoleRepositoryOutPort {

    private final IMySQLJPARolRepository repository;

    @Override
    public Optional<Role> findById(String id) {
        Optional<RoleEntity> rolEntity = repository.findById(id);
        return rolEntity.map(RolEntityMapper::toDomain);
    }

    @Override
    public Optional<Role> findByName(String name) {
        Optional<RoleEntity> rolEntity = repository.findByName(name);
        return rolEntity.map(RolEntityMapper::toDomain);
    }

    @Override
    public PaginatedResponse<Role> findAll(PaginatedResponseParams params) {
        Pageable pageable = PageableUtils.getFromPaginatedResponseParams(params);
        Page<RoleEntity> pageRes = repository.findAll(pageable);
        PaginatedResponse<Role> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setItems(pageRes.getContent().stream().map(RolEntityMapper::toDomain).toList());
        paginatedResponse.setTotalItems(pageRes.getTotalElements());
        paginatedResponse.setTotalPages(pageRes.getTotalPages());
        paginatedResponse.setPage(pageRes.getNumber());
        paginatedResponse.setSize(pageRes.getSize());
        return paginatedResponse;
    }

}
