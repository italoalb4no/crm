package com.example.application.data.repository;

import com.example.application.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

}
