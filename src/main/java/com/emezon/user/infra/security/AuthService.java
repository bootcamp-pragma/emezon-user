package com.emezon.user.infra.security;

import com.emezon.user.app.dtos.auth.AuthRequest;
import com.emezon.user.app.dtos.auth.AuthResponse;
import com.emezon.user.app.handlers.IAuthHandler;
import com.emezon.user.domain.api.IJwtServicePort;
import com.emezon.user.domain.constants.UserErrorMessages;
import com.emezon.user.infra.constants.SecurityConstants;
import com.emezon.user.infra.outbound.mysql.jpa.entities.UserEntity;
import com.emezon.user.infra.outbound.mysql.jpa.repositories.IMySQLJPAUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Transactional
@RequiredArgsConstructor
public class AuthService implements IAuthHandler {

    private final IMySQLJPAUserRepository userRepository;
    private final IJwtServicePort jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse signin(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(UserErrorMessages.USER_NOT_FOUND_BY_EMAIL, request.getEmail()
                        )
                ));

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put(SecurityConstants.ROLE_NAME_CLAIM, user.getRole().getName());

        Map<String, Object> data = new HashMap<>();
        data.put("username", user.getEmail());

        String jwtToken = jwtService.generateToken(extraClaims, data);
        return new AuthResponse(jwtToken);
    }

    @Override
    public AuthResponse signup(AuthRequest request) {
        return null;
    }

}
