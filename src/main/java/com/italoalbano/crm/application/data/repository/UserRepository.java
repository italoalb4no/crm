package com.italoalbano.crm.application.data.repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import com.italoalbano.crm.application.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query("select c from UserEntity c " +
            "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<UserEntity> search(@Param("searchTerm") String searchTerm);

    @Query("select c from UserEntity c " +
            "where c.userName = userName")
    Optional<UserEntity> findUserByUserName(@Param("userName") String userName);

    @Query("select c from UserEntity c " +
            "where c.email = email")
    Optional<UserEntity> findUserByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.encryptedPassword = encryptedPassword where u.id =id")
    void updateUserPassword(@Param("id") String id, @Param("encryptedPassword") String encryptedPassword);

    @Query("select c from UserEntity c " +
            "where c.id = id")
    Optional<UserEntity> findUserById(@Param("id") String id);

}