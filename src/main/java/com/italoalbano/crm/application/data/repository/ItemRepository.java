package com.italoalbano.crm.application.data.repository;

import com.italoalbano.crm.application.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

}
