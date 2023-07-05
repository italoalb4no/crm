package com.italoalbano.crm.application.data.repository;

import com.italoalbano.crm.application.data.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    @Query("select c from CustomerEntity c where c.email = ?1")
    Optional<CustomerEntity> findCustomerByEmailAddress(String email);

//    @Query("select * from CustomerEntity limit 1000")
//    List<CustomerEntity> findAllPaged();

    @Override
    List<CustomerEntity> findAll();
}