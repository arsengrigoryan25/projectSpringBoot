package com.shopping.cart.service.mapper;

import com.shopping.cart.model.domain.dto.CartItemDto;
import com.shopping.cart.model.domain.entity.CartItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface CartItemMapper {

    CartItemMapper CART_ITEM_MAPPER_INSTANCE = Mappers.getMapper(CartItemMapper.class);

    CartItemEntity dtoToEntity(CartItemDto dto);

    Iterable<CartItemEntity> dtoListToEntityList(Iterable<CartItemDto> dto);

    CartItemDto entityToDto(CartItemEntity entity);

    CartItemDto optionalEntityToDto(Optional<CartItemEntity> entity);

    Iterable<CartItemDto> entityListToDtoList(Iterable<CartItemEntity> entity);

}
