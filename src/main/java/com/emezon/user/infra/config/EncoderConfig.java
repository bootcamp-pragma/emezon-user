package com.emezon.user.infra.config;

import com.emezon.user.domain.utils.IPasswordEncoder;
import com.emezon.user.infra.security.PasswordEncoderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IPasswordEncoder passwordEncoderImpl() {
        return new PasswordEncoderImpl(passwordEncoder());
    }

}
