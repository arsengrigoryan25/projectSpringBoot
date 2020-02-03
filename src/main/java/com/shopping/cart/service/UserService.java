package com.shopping.cart.service;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;

import java.util.Iterator;

public interface UserService {

    public String creatUser(UserDto dto) ;

    public Iterable<UserDto> getAllUsers();

    public String deleteUser(Long id);
}
