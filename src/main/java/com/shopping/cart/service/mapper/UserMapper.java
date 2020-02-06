package com.shopping.cart.service.mapper;

import com.shopping.cart.model.domain.dto.UserDto;
import com.shopping.cart.model.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER_INSTANCE = Mappers.getMapper(UserMapper.class);

    Iterable<UserEntity> dtoListToEntityList(Iterable<UserDto> dto);

    UserEntity dtoToEntity(UserDto dto);

    Iterable<UserDto> entityListToDtoList(Iterable<UserEntity> entity);

    UserDto entityToDto(UserEntity entity);
}