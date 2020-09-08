package com.example._Rest_Service.searchfilter;

import com.example._Rest_Service.entity.ItemEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFilter implements Specification<ItemEntity> {

    private String season;

    private String collection;

    @Override
    public Predicate toPredicate(Root<ItemEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (season != null && !season.equalsIgnoreCase("") && !season.equalsIgnoreCase("undefined")) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("season")), "%" + season.toUpperCase() + "%"));
        }
        if (collection != null && !collection.equalsIgnoreCase("") && !collection.equalsIgnoreCase("undefined")) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("collection")), "%" + collection.toUpperCase() + "%"));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
