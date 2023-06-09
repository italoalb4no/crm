package com.italoalbano.crm.application.data.service;

import com.italoalbano.crm.application.data.entity.OrderEntity;
import com.italoalbano.crm.application.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public void createOrder(OrderEntity order) {
        this.orderRepository.save(order);
    }

}
