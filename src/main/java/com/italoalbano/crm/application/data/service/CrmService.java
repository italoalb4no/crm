package com.italoalbano.crm.application.data.service;

import com.italoalbano.crm.application.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrmService {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final AddressService addressService;
    private final ItemService itemService;
    private final MyUserDetailsService userDetailsService;
    private final DocumentService documentService;

    @Autowired
    public CrmService(
            CustomerService customerService,
            OrderService orderService,
            AddressService addressService,
            ItemService itemService,
            MyUserDetailsService userDetailsService,
            DocumentService documentService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.addressService = addressService;
        this.itemService = itemService;
        this.userDetailsService = userDetailsService;
        this.documentService = documentService;
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

    public DocumentService getDocumentService() {
        return this.documentService;
    }
}