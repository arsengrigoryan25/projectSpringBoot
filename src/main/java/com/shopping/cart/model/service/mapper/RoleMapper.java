package com.shopping.cart.model.service.mapper;

import com.shopping.cart.model.domain.dto.RoleDto;
import com.shopping.cart.model.domain.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleEntity dtoToEntity(RoleDto dto);
    RoleDto entityToDto(RoleEntity entity);
}