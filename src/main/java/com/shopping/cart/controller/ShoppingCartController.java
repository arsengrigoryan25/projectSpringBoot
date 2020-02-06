package com.shopping.cart.controller;

import com.shopping.cart.model.domain.dto.CartItemDto;
import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shopping-carts")
@RestController
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/getItemsByUserId/{userId}")
    public ShoppingCartDto getItemsByUserId(@PathVariable Long userId){
        return shoppingCartService.getItemsByUserId(userId);
    }

    @GetMapping("/create")
    public ShoppingCartDto createCart(@RequestBody ShoppingCartDto shoppingCartDto, @RequestBody CartItemDto cartItemDto ) {
        return shoppingCartService.createCart(shoppingCartDto);
    }

    @DeleteMapping("/deleteItems")
    public ShoppingCartDto deleteItemsByCart(@RequestBody ShoppingCartDto shoppingCartDto){
        return shoppingCartService.deleteItemsByCart(shoppingCartDto);
    }
}