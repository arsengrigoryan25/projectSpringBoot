package com.shopping.cart.repository;

import com.shopping.cart.domain.entity.ShoppingCartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCartEntity, Integer> {
    List<ShoppingCartEntity> findByUserId(String userId);

}
