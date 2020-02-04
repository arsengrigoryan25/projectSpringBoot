package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.ShoppingCartDto;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.service.ShoppingCartService;
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

    @PostMapping("/addProductInUserCart")
    @PreAuthorize("hasRole('USER')")
    public void addProductInUserCart(@RequestBody ShoppingCartDto shoppingCartDto){
        shoppingCartService.addProductInUserCart(shoppingCartDto);
    }

    @GetMapping("/getProductsFromUserCart/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void getProductsFromUserCart(@PathVariable Long userId){
        shoppingCartService.getProductByUserId(userId);
    }

    @GetMapping("/getPendingProduct/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void getPendingProductFromUserCart(@PathVariable Long userId){
        shoppingCartService.getPendingProduct(userId);
    }

    @GetMapping("/approvedProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public void approvedProduct(@RequestBody ShoppingCartDto shoppingCartDto){
        shoppingCartService.approvedProduct(shoppingCartDto);
    }

    @DeleteMapping("/deleteProductsFromUserCart")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteProductInUserCart(@RequestBody ShoppingCartDto shoppingCartDto){
        shoppingCartService.deleteProductInUserCart(shoppingCartDto);
    }
}