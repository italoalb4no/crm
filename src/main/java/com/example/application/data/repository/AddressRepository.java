package com.example.application.data.repository;

import com.example.application.data.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressEntity, String> {

    @Query("select a from Addresses a where a.firstAddressLine = ?1 and a.zipCode = ?2")
    Optional<AddressEntity> findByFirstAddressLineAndZipCode(String firstAddressLine, String zipCode);

}