package com.emezon.user.infra.outbound.mysql.jpa.repositories;

import com.emezon.user.infra.outbound.mysql.jpa.constants.RoleEntityConstants;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IMySQLJPARolRepository extends JpaRepository<RoleEntity, String> {

    @Query("SELECT r FROM " + RoleEntityConstants.ENTITY_NAME + " r WHERE r.name = :name")
    Optional<RoleEntity> findByName(String name);

}
