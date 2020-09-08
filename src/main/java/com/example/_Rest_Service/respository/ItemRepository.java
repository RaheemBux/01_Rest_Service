package com.example._Rest_Service.respository;

import com.example._Rest_Service.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity,String>, JpaSpecificationExecutor<ItemEntity> {

    List<ItemEntity> findAll();
    List<ItemEntity> findAll(Specification<ItemEntity> specification);
    ItemEntity findByUniqueId(String id);


}
