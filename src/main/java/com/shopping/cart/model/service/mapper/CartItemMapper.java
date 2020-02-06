package com.shopping.cart.model.service.mapper;

import com.shopping.cart.model.domain.dto.CartItemDto;
import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.domain.entity.CartItemEntity;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper
public interface CartItemMapper {
    CartItemEntity dtoToEntity(CartItemDto dto);
    Iterable<CartItemEntity> dtoListToEntityList(Iterable<CartItemDto> dto);
    CartItemDto entityToDto(CartItemEntity entity);
    CartItemDto optionalEntityToDto(Optional<CartItemEntity> entity);
    Iterable<CartItemDto> entityListToDtoList(Iterable<CartItemEntity> entity);
}
