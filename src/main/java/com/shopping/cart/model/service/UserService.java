package com.shopping.cart.model.service;

import com.shopping.cart.model.domain.dto.UserDto;
import com.shopping.cart.model.domain.entity.UserEntity;

public interface UserService {

    public UserDto creatUser(UserEntity entity) ;
    public Iterable<UserDto> getAllUsers();
    public Long deleteUser(Long id);
}
