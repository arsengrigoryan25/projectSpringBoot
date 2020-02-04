package com.shopping.cart.model.service;

import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;

public interface ShoppingCartService {

    ShoppingCartDto addProductInUserCart(ShoppingCartDto shoppingCartDto);
    Iterable<ShoppingCartDto> getProductByUserId(Long userId);
    Iterable<ShoppingCartDto> getPendingProduct(Long userId);
    ShoppingCartDto approvedProduct(ShoppingCartDto shoppingCartDto);
    void deleteProductInUserCart(ShoppingCartDto shoppingCartDto);
}