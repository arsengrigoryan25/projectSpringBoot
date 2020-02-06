package com.shopping.cart.controller;

import com.shopping.cart.model.domain.dto.CartItemDto;
import com.shopping.cart.model.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart_item")
@RestController
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/create")
    public CartItemDto createItem(@RequestBody CartItemDto cartItem){
        return cartItemService.createItem(cartItem);
    }

    @GetMapping("/getItemsById/{userId}")
    public CartItemDto getItemsById(@PathVariable Long id) {
        return cartItemService.getItemsById(id);
    }

    @GetMapping("/getAllPendingItems")
    public Iterable<CartItemDto> getAllPendingItems(){
        return cartItemService.getAllPendingItems();
    }

    @GetMapping("/approvedItems")
    public CartItemDto approvedItems(@RequestBody CartItemDto cartItem){
        return cartItemService.approvedItems(cartItem);
    }

    @DeleteMapping("/deleteItem")
    public void deleteItem(@RequestBody CartItemDto cartItem){
        cartItemService.deleteItem(cartItem);
    }
}