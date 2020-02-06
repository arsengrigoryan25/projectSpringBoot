package com.shopping.cart.service;

import com.shopping.cart.model.domain.dto.CartItemDto;

public interface CartItemService {

    CartItemDto createItem(CartItemDto cartItem);

    CartItemDto getItemsById(Long id);

    Iterable<CartItemDto> getAllPendingItems();

    CartItemDto approvedItems(CartItemDto cartItem);

    CartItemDto deleteItem(CartItemDto cartItemDto);
}