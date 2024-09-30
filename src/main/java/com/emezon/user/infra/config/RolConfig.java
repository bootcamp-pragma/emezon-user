package com.emezon.user.infra.config;

import com.emezon.user.app.handlers.IRolHandler;
import com.emezon.user.app.services.RolService;
import com.emezon.user.domain.api.rol.IPersistRolInPort;
import com.emezon.user.domain.spi.IRolRepositoryOutPort;
import com.emezon.user.domain.usecases.PersistRolUseCase;
import com.emezon.user.infra.outbound.mysql.jpa.adapters.MySQLJPARolAdapter;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPARolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RolConfig {

    private final IMySQLJPARolRepository mySQLJPARolRepository;

    @Bean
    public IRolRepositoryOutPort rolRepositoryOutPort() {
        return new MySQLJPARolAdapter(mySQLJPARolRepository);
    }

    @Bean
    public IPersistRolInPort persistRolInPort() {
        return new PersistRolUseCase(rolRepositoryOutPort());
    }

    @Bean
    public IRolHandler rolHandler() {
        return new RolService(persistRolInPort());
    }

}
