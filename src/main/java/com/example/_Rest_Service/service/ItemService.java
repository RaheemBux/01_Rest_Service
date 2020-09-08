package com.example._Rest_Service.service;

import com.example._Rest_Service.entity.ItemEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ItemService {
    ItemEntity createItemEntity(ItemEntity itemEntity);
    ItemEntity updateItemEntity(ItemEntity itemEntity);
    ItemEntity deleteItemEntity(ItemEntity itemEntity);
    ItemEntity findByUniqueId(String id);
    List<ItemEntity> findAll();
    List<ItemEntity> findAll(Specification<ItemEntity> specification);
}
