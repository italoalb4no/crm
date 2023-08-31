package com.italoalbano.crm.application.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Date;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final String SECRET_KEY = "your_secret_key"; // Change this to a secure secret key
    private final long EXPIRATION_TIME = 864_000_000; // 10 days in milliseconds

    public JwtAuthenticationFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis() + this.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, this.SECRET_KEY)
                .compact();

        response.addHeader("Authorization", "Bearer " + token);
    }
}
