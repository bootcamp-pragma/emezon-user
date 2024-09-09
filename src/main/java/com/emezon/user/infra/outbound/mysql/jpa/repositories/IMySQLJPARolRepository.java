package com.emezon.user.infra.outbound.mysql.jpa.repositories;

import com.emezon.user.infra.outbound.mysql.jpa.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMySQLJPARolRepository extends JpaRepository<RolEntity, String> {

    @Query("SELECT r FROM roles r WHERE LOWER(r.name)  = LOWER(:name)")
    RolEntity findByName(String name);

}
