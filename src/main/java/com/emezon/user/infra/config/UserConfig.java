package com.emezon.user.infra.config;

import com.emezon.user.app.handlers.IUserHandler;
import com.emezon.user.app.services.UserService;
import com.emezon.user.domain.api.IPersistUserInPort;
import com.emezon.user.domain.api.IRetrieveUserInPort;
import com.emezon.user.domain.spi.IUserRepositoryOutPort;
import com.emezon.user.domain.usecases.PersistUserUseCase;
import com.emezon.user.domain.usecases.RetrieveUserUseCase;
import com.emezon.user.domain.utils.IPasswordEncoder;
import com.emezon.user.infra.outbound.mysql.jpa.adapters.MySQLJPAUserAdapter;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPAUserRepository;
import com.emezon.user.infra.security.PasswordEncoderImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class UserConfig {

    private final IMySQLJPAUserRepository mySQLJPAUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public IUserRepositoryOutPort userRepositoryOutPort() {
        return new MySQLJPAUserAdapter(mySQLJPAUserRepository);
    }

    @Bean
    public IRetrieveUserInPort retrieveUserInPort() {
        return new RetrieveUserUseCase(userRepositoryOutPort());
    }

    @Bean
    public IPasswordEncoder passwordEncoderImpl() {
        return new PasswordEncoderImpl(passwordEncoder);
    }

    @Bean
    public IPersistUserInPort persistUserInPort() {
        return new PersistUserUseCase(userRepositoryOutPort(), passwordEncoderImpl());
    }

    @Bean
    public IUserHandler userHandler() {
        return new UserService(retrieveUserInPort());
    }

}
