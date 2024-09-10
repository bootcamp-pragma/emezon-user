package com.emezon.user.infra.config;

import com.emezon.user.app.services.RolService;
import com.emezon.user.domain.ports.outbound.IRolRepositoryOutPort;
import com.emezon.user.domain.usecases.PersistRolUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolConfig {

    @Bean
    public RolService rolService(IRolRepositoryOutPort rolRepositoryOutPort) {
        return new RolService(
                new PersistRolUseCase(rolRepositoryOutPort)
        );
    }

}
