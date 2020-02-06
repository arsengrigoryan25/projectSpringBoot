package com.shopping.cart.service;

import com.shopping.cart.model.domain.dto.UserDto;

public interface UserService {

    UserDto creatUser(UserDto dto);

    Iterable<UserDto> getAllUsers();

    Long deleteUser(Long id);
}
