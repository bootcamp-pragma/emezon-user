package com.emezon.user.infra.security;

import com.emezon.user.domain.spi.IJwtServicePort;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtService implements IJwtServicePort {
    @Value("${spring.security.jwt.secret}")
    private String secret;

    @Value("${spring.security.jwt.expiration-time}")
    private long expirationTime;

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, claims -> (String) claims.get("sub"));
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public <T> T extractClaim(String token, Function<Map<String, Object>, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        Map<String, Object> claimsMap = new HashMap<>(claims);
        return claimsResolver.apply(claimsMap);
    }

    @Override
    public String generateToken(Map<String, Object> extraClaims, Map<String, Object> data) {
        if (!data.containsKey("username")) {
            throw new IllegalArgumentException("Data must contain a username");
        }
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject((String) data.get("username"))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (expirationTime * 1000L)))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, claim -> {
            Number exp = (Number) claim.get("exp");
            long expLong = exp.longValue();
            return new Date(expLong * 1000);
        });
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    @Override
    public boolean isTokenValid(String token, Map<String, Object> data) {
        final String username = extractUsername(token);
        if (isTokenExpired(token)) {
            System.out.println("Token has expired");
            throw new ExpiredJwtException(null, null, "Token has expired");
        }
        return username.equals(data.get("username"));
    }
}
