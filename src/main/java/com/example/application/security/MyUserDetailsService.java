package com.example.application.security;

import com.example.application.data.entity.PasswordResetTokenEntity;
import com.example.application.data.entity.UserEntity;
import com.example.application.data.repository.PasswordTokenRepository;
import com.example.application.data.repository.UserRepository;
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
    private UserRepository userRepository;
    private PasswordTokenRepository tokenRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MyUserDetailsService(PasswordTokenRepository tokenRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserByUserName(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else return new MyUserDetails(user);
    }

    public UserEntity loadUserObjectByUsername(String username) {
        return userRepository.findUserByUserName(username).orElse(null);
    }

    public void createUser(UserEntity user) {
        // Get password that needs to be encrypted and saved
        String passwordToBeEncrypted = user.getEncryptedPassword();
        user.setEncryptedPassword(passwordEncoder.encode(passwordToBeEncrypted));
        userRepository.save((UserEntity) user);
    }

    public UserEntity loadUserByEmail(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserByEmail(email).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        } else return user;
    }

    public UserEntity loadUserById(String id) throws NotFoundException {
        UserEntity user = userRepository.findUserById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException(id.toString());
        } else return user;
    }

    public void createPasswordResetTokenForUser(UUID userId, String token) {
        PasswordResetTokenEntity myToken = new PasswordResetTokenEntity(token, userId);
        tokenRepository.save(myToken);
    }

    @Transactional
    public void changePassword(String userId, String password) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setEncryptedPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }
    }
}
