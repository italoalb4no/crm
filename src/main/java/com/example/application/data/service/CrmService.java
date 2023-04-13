package com.example.application.data.service;

import com.example.application.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrmService {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final AddressService addressService;
    private final ItemService itemService;
    private MyUserDetailsService userDetailsService;


    @Autowired
    public CrmService(
            CustomerService customerService,
            OrderService orderService,
            AddressService addressService,
            ItemService itemService,
            MyUserDetailsService userDetailsService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.addressService = addressService;
        this.itemService = itemService;
        this.userDetailsService = userDetailsService;
    }

    public CustomerService getCustomerService() {
        return this.customerService;
    }

    public OrderService getOrderService() {
        return this.orderService;
    }

    public AddressService getAddressService() {
        return this.addressService;
    }

    public ItemService getItemService() {
        return this.itemService;
    }

    public MyUserDetailsService getUserDetailsService() {
        return this.userDetailsService;
    }
}