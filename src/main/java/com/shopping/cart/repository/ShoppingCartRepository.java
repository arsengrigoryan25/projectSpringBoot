package com.shopping.cart.repository;

import com.shopping.cart.enums.BasketItemsStatus;
import com.shopping.cart.domain.entity.ShoppingCartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCartEntity, Long> {
    Iterable<ShoppingCartEntity> findByUserId(Long userId);
    Iterable<ShoppingCartEntity> findByUserIdAndStatus(Long userId, BasketItemsStatus Status);
}
