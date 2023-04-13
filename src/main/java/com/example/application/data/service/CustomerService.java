package com.example.application.data.service;

import com.example.application.data.entity.CustomerEntity;
import com.example.application.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<CustomerEntity> getAllCustomers() {
        return this.customerRepository.findAll();
    }

//    public List<CustomerEntity> getAllCustomersPaged() {
//        Page<CustomerEntity> page = this.customerRepository.findAll(Pageable.ofSize(1000));
//        return page.getContent();
//    }

    public void createCustomer(CustomerEntity customer) {
        this.customerRepository.save(customer);
    }

    public boolean isEmailAddressAlreadyRegistered(String email) {
        Optional<CustomerEntity> customer = this.customerRepository.findCustomerByEmailAddress(email);
        return customer.isPresent();
    }

}