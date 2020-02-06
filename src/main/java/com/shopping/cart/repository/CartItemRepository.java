package com.shopping.cart.repository;

import com.shopping.cart.model.domain.entity.CartItemEntity;
import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartItemRepository extends CrudRepository<CartItemEntity, Long> {

    Set<CartItemEntity> findByStatus(BasketItemsStatus status);
}
