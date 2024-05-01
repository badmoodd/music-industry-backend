package com.amaizing.crudtemplate.services.jwt;

import com.amaizing.crudtemplate.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.lifetime}")
    private Duration jwtLifetime;

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        // payload
        claims.put("username", user.getUsername());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());

        var issuedDate = new Date();
        var expiredDate = new Date(issuedDate.getTime() + jwtLifetime.toMillis());

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] secret = Base64.getEncoder().encode(secretKey.getBytes());
        Key signingKey = new SecretKeySpec(secret, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(user.getUsername()) // usually it's username
                .setClaims(claims)
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(signingKey, signatureAlgorithm)
                .compact();
    }

    public String getUUID(String token) {
        return getAllClaimsFromToken(token).getBody().get("uuid", String.class);
    }

    public Jws<Claims> getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token);
    }

    public String getJwtTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
