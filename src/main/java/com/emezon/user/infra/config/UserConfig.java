package com.emezon.user.infra.config;

import com.emezon.user.app.handlers.IAdminHandler;
import com.emezon.user.app.handlers.IAuxBodegaHandler;
import com.emezon.user.app.handlers.IClientHandler;
import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.services.AdminService;
import com.emezon.user.app.services.AuxBodegaService;
import com.emezon.user.app.services.ClientService;
import com.emezon.user.app.services.UserService;
import com.emezon.user.domain.api.IPersistUserInPort;
import com.emezon.user.domain.api.IRetrieveUserInPort;
import com.emezon.user.domain.spi.IRoleRepositoryOutPort;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;
import com.emezon.user.domain.usecases.PersistUserUseCase;
import com.emezon.user.domain.usecases.RetrieveUserUseCase;
import com.emezon.user.domain.utils.IPasswordEncoder;
import com.emezon.user.infra.outbound.mysql.jpa.adapters.MySQLJPAUserAdapter;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPAUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UserConfig {

    private final IMySQLJPAUserRepository mySQLJPAUserRepository;
    private final IRoleRepositoryOutPort roleRepositoryOutPort;
    private final IPasswordEncoder passwordEncoderImpl;

    @Bean
    public IUserRepositoryOutPort userRepositoryOutPort() {
        return new MySQLJPAUserAdapter(mySQLJPAUserRepository);
    }

    @Bean
    public IRetrieveUserInPort retrieveUserInPort() {
        return new RetrieveUserUseCase(userRepositoryOutPort());
    }

    @Bean
    public IPersistUserInPort persistUserInPort() {
        return new PersistUserUseCase(userRepositoryOutPort(), passwordEncoderImpl, roleRepositoryOutPort);
    }

    @Bean
    public IUserHandler userHandler() {
        return new UserService(retrieveUserInPort(), persistUserInPort());
    }

    @Bean
    public IAdminHandler adminHandler() {
        return new AdminService(userHandler());
    }

    @Bean
    public IAuxBodegaHandler auxBodegaHandler() {
        return new AuxBodegaService(userHandler());
    }

    @Bean
    public IClientHandler clientHandler() {
        return new ClientService(userHandler());
    }

}
