package com.italoalbano.crm.application.data.service

import com.italoalbano.crm.application.security.MyUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CrmService @Autowired constructor(
    val customerService: CustomerService,
    val orderService: OrderService,
    val addressService: AddressService,
    val itemService: ItemService,
    val userDetailsService: MyUserDetailsService,
    val documentService: DocumentService
) 