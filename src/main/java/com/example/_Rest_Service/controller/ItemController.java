package com.example._Rest_Service.controller;

import com.example._Rest_Service.entity.ItemEntity;
import com.example._Rest_Service.respository.CustomRepository;
import com.example._Rest_Service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    CustomRepository customRepository;

    @PostMapping(value = "/getAllWithFilters")
    public List<ItemEntity> get(ItemEntity itemEntity) {
        return customRepository.getAll(itemEntity);
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute ItemEntity itemEntity) {
        itemService.createItemEntity(itemEntity);
        return "Added Successfully";
    }
    @PostMapping(value = "/update")
    public String update(@ModelAttribute ItemEntity itemEntity) {
        itemService.updateItemEntity(itemEntity);
        return "Updated Successfully";
    }

}
