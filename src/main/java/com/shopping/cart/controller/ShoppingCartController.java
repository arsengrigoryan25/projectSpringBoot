package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.ShoppingCartDto;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shopping-carts")
@RestController
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/addProductInUserCart")
    public void addProductInUserCart(@RequestBody ShoppingCartDto shoppingCartDto){
        shoppingCartService.addProductInUserCart(shoppingCartDto);
    }

    @GetMapping("/getProductsFromUserCart/{userId}")
    public void getProductsFromUserCart(@PathVariable Long userId){
        shoppingCartService.getProductFromUserCartByUserId(userId);
    }

    @DeleteMapping("/deleteProductsFromUserCart")
    public void deleteProductInUserCart(@RequestBody ShoppingCartDto shoppingCartDto){
        shoppingCartService.deleteProductInUserCart(shoppingCartDto);
    }
}