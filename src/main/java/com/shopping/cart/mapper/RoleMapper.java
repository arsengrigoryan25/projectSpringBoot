package com.shopping.cart.mapper;

import com.shopping.cart.domain.dto.RoleDto;
import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.RoleEntity;
import com.shopping.cart.domain.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleEntity dtoToEntity(RoleDto dto);
    RoleDto entityToDto(RoleEntity entity);
}