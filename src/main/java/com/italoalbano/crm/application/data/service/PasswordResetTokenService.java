package com.italoalbano.crm.application.data.service;

import com.italoalbano.crm.application.data.entity.PasswordResetTokenEntity;
import com.italoalbano.crm.application.data.repository.PasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenService {
    @Autowired
    private PasswordTokenRepository tokenRepository;

    public PasswordResetTokenEntity loadTokenByToken(String token) {
        return this.tokenRepository.findByToken(token);
    }

    public void deleteToken(PasswordResetTokenEntity token) {
        this.tokenRepository.delete(token);
    }
}
