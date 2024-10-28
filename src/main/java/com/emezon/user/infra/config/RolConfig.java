package com.emezon.user.infra.config;

import com.emezon.user.app.handlers.IRoleHandler;
import com.emezon.user.app.services.RoleService;
import com.emezon.user.domain.api.IRetrieveRoleInPort;
import com.emezon.user.domain.spi.IRoleRepositoryOutPort;
import com.emezon.user.domain.usecases.RetrieveRoleUseCase;
import com.emezon.user.infra.outbound.mysql.jpa.adapters.MySQLJPARoleAdapter;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPARolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RolConfig {

    private final IMySQLJPARolRepository mySQLJPARolRepository;

    @Bean
    public IRoleRepositoryOutPort rolRepositoryOutPort() {
        return new MySQLJPARoleAdapter(mySQLJPARolRepository);
    }

    @Bean
    IRetrieveRoleInPort retrieveRolInPort() {
        return new RetrieveRoleUseCase(rolRepositoryOutPort());
    }

    @Bean
    public IRoleHandler rolHandler() {
        return new RoleService(retrieveRolInPort());
    }

}
