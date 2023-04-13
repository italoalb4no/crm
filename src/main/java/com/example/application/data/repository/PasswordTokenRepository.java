package com.example.application.data.repository;

import com.example.application.data.entity.PasswordResetTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetTokenEntity, UUID> {
    //@Query("select c from PasswordResetTokenEntity c where c.token = token")
    //PasswordResetTokenEntity findToken(@Param("token") String token);

    PasswordResetTokenEntity findByToken(String keyword);

}
