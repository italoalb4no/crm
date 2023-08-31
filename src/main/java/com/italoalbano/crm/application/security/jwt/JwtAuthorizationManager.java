package com.italoalbano.crm.application.security.jwt;

import com.italoalbano.crm.application.security.MyUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.security.Key;
import java.util.Date;
import java.util.function.Supplier;

public class JwtAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    private static final String SECRET_KEY = "YourSecretKeyHere";
    private static final long EXPIRATION_TIME_MS = 30 * 60 * 1000; // 30 minutes

    public boolean isUserLoggedIn(MyUserDetails user) {
        // In this example, we assume that if the User object is not null, the user is considered logged in.
        return user != null;
    }

    public MyUserDetails performLogin(String username, String password) {
        // Your authentication logic here, for example, validating username and password
        // ...
        // If the authentication is successful, create and return a User object with the username
        return new MyUserDetails(null);
    }

    public boolean isAccessGranted(MyUserDetails user, String path) {
        // Your authorization logic here, for example, checking user roles or permissions for the requested path
        // ...
        // Return true if the user has access, otherwise false
        return true;
    }

    public String createToken(String username) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS);
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (Exception ex) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        return new AuthorizationDecision(true);
    }
}
