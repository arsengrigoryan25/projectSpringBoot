package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.ShoppingCart;
import com.shopping.cart.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserController userController;

    @Autowired
    public UserController(UserController userController) {
        this.userController = userController;
    }

    @RequestMapping("/registration")
    public void addUser(User user){
        userController.addUser(user);
    }



}