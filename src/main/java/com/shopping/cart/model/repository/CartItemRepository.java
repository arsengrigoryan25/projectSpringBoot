package com.shopping.cart.model.repository;

import com.shopping.cart.model.domain.entity.CartItemEntity;
import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {

    Set<CartItemEntity> findByCartId(Long cartId);
    Set<CartItemEntity> findByStatus(BasketItemsStatus status);
}
