package com.shopping.cart.service;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;

public interface UserService {

    public String creatUser(UserEntity entity) ;

    public Iterable<UserDto> getAllUsers();

    public String deleteUser(Long id);
}
