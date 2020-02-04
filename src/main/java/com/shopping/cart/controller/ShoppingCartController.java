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

    @PostMapping("/addProductInUserCart")
    @PreAuthorize("hasRole('USER')")
    public ShoppingCartDto addProductInUserCart(@RequestBody ShoppingCartDto shoppingCartDto){
        return shoppingCartService.addProductInUserCart(shoppingCartDto);
    }

    @GetMapping("/getProductsFromUserCart/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Iterable<ShoppingCartDto> getProductsFromUserCart(@PathVariable Long userId){
        return shoppingCartService.getProductByUserId(userId);
    }

    @GetMapping("/getPendingProduct/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<ShoppingCartDto> getPendingProductFromUserCart(@PathVariable Long userId){
        return shoppingCartService.getPendingProduct(userId);
    }

    @GetMapping("/approvedProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public ShoppingCartDto approvedProduct(@RequestBody ShoppingCartDto shoppingCartDto){
        return shoppingCartService.approvedProduct(shoppingCartDto);
    }

    @DeleteMapping("/deleteProductsFromUserCart")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteProductInUserCart(@RequestBody ShoppingCartDto shoppingCartDto){
        shoppingCartService.deleteProductInUserCart(shoppingCartDto);
    }
}