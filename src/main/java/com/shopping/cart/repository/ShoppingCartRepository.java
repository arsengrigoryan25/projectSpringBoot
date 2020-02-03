package com.shopping.cart.repository;

import com.shopping.cart.domain.entity.ShoppingCartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCartEntity, Long> {
    Iterator<ShoppingCartEntity> findByUserId(String userId);

}
