package com.italoalbano.crm.application.data.repository;

import com.italoalbano.crm.application.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
