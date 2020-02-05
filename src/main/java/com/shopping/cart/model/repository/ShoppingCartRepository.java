package com.shopping.cart.model.repository;

import com.shopping.cart.model.domain.entity.ShoppingCartEntity;
import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
    ShoppingCartEntity findByUserId(Long userId);
}
