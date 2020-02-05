package com.shopping.cart.controller;

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

    @GetMapping("/getProductsFromUserCart/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ShoppingCartDto getCartByUserId(@PathVariable Long userId){
        return shoppingCartService.getCartByUserId(userId);
    }

}