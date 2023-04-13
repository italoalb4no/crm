package com.example.application.data.service;

import com.example.application.data.entity.ItemEntity;
import com.example.application.data.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> getAllItems() {
        return this.itemRepository.findAll();
    }

    public void createItem(ItemEntity item) {
        this.itemRepository.save(item);
    }

}

