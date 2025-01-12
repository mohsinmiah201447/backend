package com.isdbbros.realestate.utils.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.isdbbros.realestate.constants.Constants.*;

@Component
@Slf4j
public class JwtUtil {
    private final SecretKeySpec secretKeySpec;

    @Value("${organization.name}")
    private String organizationName;

    public JwtUtil() {
        byte[] key = UUID.randomUUID().toString().substring(0, 32).getBytes();
        this.secretKeySpec = new SecretKeySpec(key, SignatureAlgorithm.HS256.getJcaName());
    }

    public String createAccessToken(UserDetails user) {
        try {
            return Jwts.builder()
                    .setIssuer(organizationName)
                    .setSubject(user.getUsername())
                    .setNotBefore(Date.from(Instant.now()))
                    .setIssuedAt(new Date())
                    .setExpiration(Date.from(Instant.now().plusMillis(ACCESS_TOKEN_DURATION_MILLISECONDS)))
                    .claim(AUTHORITIES_KEY, user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .signWith(secretKeySpec)
                    .compact();
        } catch (Exception e) {
            log.error(this.getClass().getName(), e);
        }
        return null;
    }

    public String createRefreshToken(String subject) {
        try {
            return Jwts.builder()
                    .setIssuer(organizationName)
                    .setSubject(subject)
                    .setNotBefore(Date.from(Instant.now()))
                    .setIssuedAt(new Date())
                    .setExpiration(Date.from(Instant.now().plusMillis(ACCESS_TOKEN_DURATION_MILLISECONDS)))
                    .signWith(secretKeySpec)
                    .compact();
        } catch (Exception e) {
            log.error(this.getClass().getName(), e);
        }
        return null;
    }

    public Claims verifyToken(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKeySpec)
                .build()
                .parseClaimsJws(token);
        return claimsJws.getBody();
    }

}
