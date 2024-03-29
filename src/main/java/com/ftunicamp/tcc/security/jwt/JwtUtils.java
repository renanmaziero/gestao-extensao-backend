package com.ftunicamp.tcc.security.jwt;

import com.ftunicamp.tcc.dto.Sessao;
import com.ftunicamp.tcc.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${gestao.extensao.jwtSecret}")
    private String jwtSecret;

    @Value("${gestao.extensao.tempoExpiracaoJwt}")
    private long jwtExpirationMs;

    @Getter
    private Sessao sessao;

    @Autowired
    private UserDetailsService userDetailsService;

    public String generateJwtToken(Authentication authentication, UserDetailsImpl userPrincipal) {

        var profiles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        var userDetails = userDetailsService.loadUserByUsername(userPrincipal.getUsername());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .claim("profiles", profiles)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public Sessao obterSessao(String token) {
        var claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

        var sessao = new Sessao();
        sessao.setUsername(claims.getSubject());
        sessao.setProfiles(claims.get("profiles", ArrayList.class));

        this.sessao = sessao;

        return sessao;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
