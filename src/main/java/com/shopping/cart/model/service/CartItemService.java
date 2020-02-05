package com.shopping.cart.model.service;

import com.shopping.cart.model.domain.dto.CartItemDto;

public interface CartItemService {

    CartItemDto addItemInUserCart(CartItemDto cartItem);
    Iterable<CartItemDto> getProductByCartId(Long cartId);
    Iterable<CartItemDto> getAllPendingItems();
    CartItemDto approvedItems(CartItemDto cartItem);
    CartItemDto deleteItemInUserCart(CartItemDto cartItemDto);
}