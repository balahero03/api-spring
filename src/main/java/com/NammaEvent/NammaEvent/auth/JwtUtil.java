package com.NammaEvent.NammaEvent.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 60;
    private static final long REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 7;

    public String extractUserName(String Token) {
        return extractClaim(Token, Claims::getSubject);
    }
    public Date extractExpiration(String Token) {
        return extractClaim(Token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String Token){
        return extractExpiration(Token).before(new Date());
    }

    public String GenerateAccessToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername(),ACCESS_TOKEN_EXPIRATION);
    }

    public String GenerateRefreshToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername(),REFRESH_TOKEN_EXPIRATION);
    }

    private String createToken(Map<String,Object> claims,String subject,long expiration){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(SECRET_KEY).compact();
    }

    public Boolean validateToken(String Token,UserDetails userDetails) {
        final String username = extractUserName(Token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(Token));
    }

}
