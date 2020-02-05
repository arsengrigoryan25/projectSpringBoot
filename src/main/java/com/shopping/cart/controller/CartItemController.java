package com.shopping.cart.controller;

import com.shopping.cart.model.domain.dto.CartItemDto;
import com.shopping.cart.model.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shopping-carts")
@RestController
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/addItemInCart")
    public CartItemDto addItemInUserCart(@RequestBody CartItemDto cartItem){
        return cartItemService.addItemInUserCart(cartItem);
    }

    @GetMapping("/getProductByCartId/{cartId}")
    public Iterable<CartItemDto> getProductByCartId(@PathVariable Long cartId){
        return cartItemService.getProductByCartId(cartId);
    }

    @GetMapping("/getAllPendingItems")
    public Iterable<CartItemDto> getAllPendingItems(){
        return cartItemService.getAllPendingItems();
    }

    @GetMapping("/approvedItems")
    public CartItemDto approvedItemsInCart(@RequestBody CartItemDto cartItem){
        return cartItemService.approvedItems(cartItem);
    }

    @DeleteMapping("/deleteItemInUserCart")
    public void deleteItemInUserCart(@RequestBody CartItemDto cartItem){
        cartItemService.deleteItemInUserCart(cartItem);
    }
}