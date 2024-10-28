package com.emezon.user.infra.outbound.mysql.jpa.repositories;

import com.emezon.user.infra.outbound.mysql.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IMySQLJPAUserRepository extends JpaRepository<UserEntity, String> {

    @Query("SELECT u FROM users u WHERE LOWER(u.email) = LOWER(:email)")
    Optional<UserEntity> findByEmail(String email);

}
