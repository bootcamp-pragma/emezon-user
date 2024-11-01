package com.emezon.user.infra.security;

import com.emezon.user.app.dtos.auth.AuthRequest;
import com.emezon.user.app.dtos.auth.AuthResponse;
import com.emezon.user.app.dtos.user.CreateClientDTO;
import com.emezon.user.app.dtos.user.UserDTO;
import com.emezon.user.app.handlers.IAuthHandler;
import com.emezon.user.app.handlers.IClientHandler;
import com.emezon.user.domain.spi.IJwtServicePort;
import com.emezon.user.domain.api.IRetrieveUserInPort;
import com.emezon.user.domain.constants.UserErrorMessages;
import com.emezon.user.domain.models.User;
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

    private final IRetrieveUserInPort retrieveUserInPort;
    private final IJwtServicePort jwtService;
    private final AuthenticationManager authenticationManager;
    private final IClientHandler clientHandler;

    public AuthResponse signin(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = retrieveUserInPort.findByEmail(request.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException(UserErrorMessages.USER_NOT_FOUND)
        );

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put(SecurityConstants.ROLE_NAME_CLAIM, user.getRole().getName());

        Map<String, Object> data = new HashMap<>();
        data.put("username", user.getEmail());

        String jwtToken = jwtService.generateToken(extraClaims, data);
        return new AuthResponse(jwtToken);
    }

    @Override
    public AuthResponse signup(CreateClientDTO clientDTO) {
        UserDTO user = clientHandler.createClient(clientDTO);
        if (user == null) {
            throw new RuntimeException("Error creating user");
        }
        AuthRequest authRequest = new AuthRequest(user.getEmail(), clientDTO.getPassword());
        return signin(authRequest);
    }

}
