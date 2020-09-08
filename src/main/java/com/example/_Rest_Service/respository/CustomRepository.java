package com.example._Rest_Service.respository;

import com.example._Rest_Service.entity.ItemEntity;

import java.util.List;

public interface CustomRepository {
    List<ItemEntity> getAll(ItemEntity itemEntity);

}
