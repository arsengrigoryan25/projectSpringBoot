package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.Product;
import com.shopping.cart.domain.dto.ShoppingCart;
import com.shopping.cart.service.ProductService;
import com.shopping.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@RestController
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping("/shoppingCart/addProductInUserCart")
    public void addProductInUserCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartService.addProductInUserCart(shoppingCart);
    }



}