package com.emezon.user.infra.security;

import com.emezon.user.app.handlers.IAuthHandler;
import com.emezon.user.app.handlers.IClientHandler;
import com.emezon.user.domain.spi.IJwtServicePort;
import com.emezon.user.domain.api.IRetrieveUserInPort;
import com.emezon.user.domain.constants.UserErrorMessages;
import com.emezon.user.domain.models.UserRoles;
import com.emezon.user.infra.inbound.rest.constants.RestApiConstants;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPAUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final IRetrieveUserInPort retrieveUserInPort;
    private final IMySQLJPAUserRepository mySQLJPAUserRepository;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final IClientHandler clientHandler;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public IJwtServicePort jwtService() {
        return new JwtService();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> mySQLJPAUserRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(UserErrorMessages.USER_NOT_FOUND)
        );
    }

    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter(jwtService(), userDetailsService());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        .requestMatchers(SecurityConstants.WHITE_LIST_URL).permitAll()
                        .requestMatchers(RestApiConstants.API_ADMIN + "/**").hasRole(UserRoles.ADMIN.toString())
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public IAuthHandler authService() throws Exception {
        return new AuthService(retrieveUserInPort, jwtService(), authenticationManager(), clientHandler);
    }

}
