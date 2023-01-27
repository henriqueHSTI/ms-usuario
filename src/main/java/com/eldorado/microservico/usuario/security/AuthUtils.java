//package com.eldorado.microservico.usuario.security;
//
//
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.UnsupportedJwtException;
//import io.jsonwebtoken.security.Keys;
//import io.jsonwebtoken.security.SecurityException;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletResponse;
//import java.security.Key;
//
//@Component
//@Slf4j
//public class AuthUtils {
//
//    @Value("${eldorado.jwt.secret}")
//    private String jwtSecret;
//
//    @SneakyThrows
//    public boolean validateJwtToken(String authToken, jakarta.servlet.http.HttpServletResponse httpServletResponse) {
//        try {
//            Jwts.parserBuilder().setSigningKey(convertSecret()).build().parseClaimsJws(authToken);
//            return true;
//        } catch (SecurityException e) {
//            log.error("Invalid JWT signature: {}", e.getMessage());
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//        } catch (MalformedJwtException e) {
//            log.error("Invalid JWT token: {}", e.getMessage());
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//        } catch (ExpiredJwtException e) {
//            log.error("JWT token is expired: {}", e.getMessage());
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            log.error("JWT token is unsupported: {}", e.getMessage());
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//        } catch (IllegalArgumentException e) {
//            log.error("JWT claims string is empty: {}", e.getMessage());
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//        }
//        return false;
//    }
//
//    public Key convertSecret() {
//        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
//    }
//}
