package com.emezon.user.domain.api;

import java.util.Map;
import java.util.function.Function;

public interface IJwtServicePort {

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Map<String, Object>, T> claimsResolver);

    String generateToken(Map<String, Object> extraClaims, Map<String, Object> data);

    boolean isTokenValid(String token, Map<String, Object> data);

}
