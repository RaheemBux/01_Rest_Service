package com.example._Rest_Service.serviceimpl;

import com.example._Rest_Service.entity.ItemEntity;
import com.example._Rest_Service.respository.ItemRepository;
import com.example._Rest_Service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public ItemEntity createItemEntity(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }

    @Override
    public ItemEntity updateItemEntity(ItemEntity itemEntity) {
        if (itemEntity.getUniqueId() != null) {
            Optional<ItemEntity> persisted = itemRepository.findById(itemEntity.getUniqueId());
            if (persisted == null) {
                return null;
            }
            ItemEntity updated = itemRepository.save(itemEntity);
            return updated;
        }
        return  null;
    }

    @Override
    public ItemEntity deleteItemEntity(ItemEntity itemEntity) {
        if (itemEntity.getUniqueId() != null) {
            itemRepository.delete(itemEntity);
            return itemEntity;
        }
        return null;
    }

    @Override
    public ItemEntity findByUniqueId(String id) {

        System.out.println("helooooooooooooooooooooo innnnnnnnn "+id);
        /*if (id != null) {
            System.out.println("helooooooooooooooooooooo "+id);
            Optional<ItemEntity> itemEntity = itemRepository.findById(id);
            if (itemEntity.isPresent()) {
                System.out.println("helooooooooooooooooooooo presnet   "+id);
                return itemEntity.get();
            }
        }*/
        return itemRepository.findByUniqueId(id);
    }

    @Override
    public List<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<ItemEntity> findAll(Specification<ItemEntity> specification) {
        return itemRepository.findAll(specification);
    }
}
