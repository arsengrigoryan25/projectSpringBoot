package com.shopping.cart.service;

import com.shopping.cart.domain.dto.ShoppingCartDto;
import com.shopping.cart.domain.entity.ShoppingCartEntity;
import com.shopping.cart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addProductInUserCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId(), shoppingCartDto.getQuantity());
        shoppingCartRepository.save(entity);
    }

    public void deleteProductInUserCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId(), shoppingCartDto.getQuantity());
        shoppingCartRepository.delete(entity);
    }

    public List<ShoppingCartEntity> findProductInUserCartByUserId(String userId) {
        return shoppingCartRepository.findByUserId(userId);
    }
}