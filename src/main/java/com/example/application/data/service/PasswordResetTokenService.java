package com.example.application.data.service;

import com.example.application.data.entity.PasswordResetTokenEntity;
import com.example.application.data.repository.PasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenService {
    @Autowired
    private PasswordTokenRepository tokenRepository;


    public PasswordResetTokenEntity loadTokenByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public void deleteToken(PasswordResetTokenEntity token) {
        tokenRepository.delete(token);
    }
}
