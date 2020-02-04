package com.shopping.cart.service.mapper;

import com.shopping.cart.domain.dto.RoleDto;
import com.shopping.cart.domain.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleEntity dtoToEntity(RoleDto dto);
    RoleDto entityToDto(RoleEntity entity);
}