package com.shopping.cart.service;

import com.shopping.cart.model.domain.dto.ShoppingCartDto;

public interface ShoppingCartService {

    ShoppingCartDto createCart(ShoppingCartDto shoppingCartDto);

    ShoppingCartDto getItemsByUserId(Long userId);

    ShoppingCartDto deleteItemsByCart(ShoppingCartDto shoppingCartDto);
}