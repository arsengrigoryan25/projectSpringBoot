package com.shopping.cart.service.mapper;

import com.shopping.cart.model.domain.dto.RoleDto;
import com.shopping.cart.model.domain.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper ROLE_MAPPER_INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleEntity dtoToEntity(RoleDto dto);

    RoleDto entityToDto(RoleEntity entity);
}