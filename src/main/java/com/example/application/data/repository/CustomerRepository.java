package com.example.application.data.repository;

import com.example.application.data.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query("select c from CustomerEntity c where c.email = ?1")
    Optional<CustomerEntity> findCustomerByEmailAddress(String email);


//    @Query("select * from CustomerEntity limit 1000")
//    List<CustomerEntity> findAllPaged();

    @Override
    List<CustomerEntity> findAll();
}