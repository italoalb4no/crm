package com.italoalbano.crm.application.data.service;

import com.italoalbano.crm.application.data.entity.AddressEntity;
import com.italoalbano.crm.application.data.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void createAddress(AddressEntity address) {
        this.addressRepository.saveAndFlush(address);
    }

    public boolean isAddressAlreadyRegistered(String firstLine, String zipCode) {
        Optional<AddressEntity> address = this.addressRepository.findByFirstAddressLineAndZipCode(firstLine, zipCode);
        return address.isPresent();
    }

}
