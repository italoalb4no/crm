package com.italoalbano.crm.application.security;

import com.italoalbano.crm.application.data.entity.PasswordResetTokenEntity;
import com.italoalbano.crm.application.data.entity.UserEntity;
import com.italoalbano.crm.application.data.repository.PasswordTokenRepository;
import com.italoalbano.crm.application.data.repository.UserRepository;
import com.vaadin.flow.router.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordTokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MyUserDetailsService(PasswordTokenRepository tokenRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findUserByUserName(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else return new MyUserDetails(user);
    }

    public UserEntity loadUserObjectByUsername(String username) {
        return this.userRepository.findUserByUserName(username).orElse(null);
    }

    public void createUser(UserEntity user) {
        // Get password that needs to be encrypted and saved
        String passwordToBeEncrypted = user.getEncryptedPassword();
        user.setEncryptedPassword(this.passwordEncoder.encode(passwordToBeEncrypted));
        this.userRepository.save(user);
    }

    public UserEntity loadUserByEmail(String email) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findUserByEmail(email).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        } else return user;
    }

    public UserEntity loadUserById(String id) throws NotFoundException {
        UserEntity user = this.userRepository.findUserById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException(id);
        } else return user;
    }

    public void createPasswordResetTokenForUser(UUID userId, String token) {
        PasswordResetTokenEntity myToken = new PasswordResetTokenEntity(token, userId);
        this.tokenRepository.save(myToken);
    }

    @Transactional
    public void changePassword(String userId, String password) {
        UserEntity user = this.userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setEncryptedPassword(this.passwordEncoder.encode(password));
            this.userRepository.save(user);
        }
    }
}
