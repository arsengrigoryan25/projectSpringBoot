package com.shopping.cart.service;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;

public interface UserService {

    public String creatUser(UserDto dto) ;

    public Iterable<UserEntity> getAllUsers();

    public String deleteUser(Long id);
}
