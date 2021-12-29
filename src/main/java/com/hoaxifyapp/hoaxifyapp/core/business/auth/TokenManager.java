package com.hoaxifyapp.hoaxifyapp.core.business.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenManager {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final int validity = 5 * 60 * 1000;

    public String createToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("turgay-dede.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+validity))
                .signWith(key)
                .compact();
    }

    public boolean tokenValidate(String token){
        return getUsernameToken(token) != null && isExpired(token);
    }

    public String getUsernameToken(String token){
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean isExpired(String token){
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
