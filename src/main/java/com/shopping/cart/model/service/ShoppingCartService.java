package com.shopping.cart.model.service;

import com.shopping.cart.model.domain.dto.ShoppingCartDto;

public interface ShoppingCartService {

    ShoppingCartDto createCart(ShoppingCartDto shoppingCartDto);
    ShoppingCartDto getCartByUserId(Long userId);
    Long deleteCartByUserId(Long userId);
}