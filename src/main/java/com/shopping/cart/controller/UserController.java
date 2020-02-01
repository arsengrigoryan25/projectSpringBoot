package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;
import com.shopping.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserDto userDto){
        return userService.creatUser(userDto);
    }

    @GetMapping("/find")
    public Iterable<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam Integer id){
        return userService.deleteUser(id);
    }
}