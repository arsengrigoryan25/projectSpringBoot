package com.shopping.cart.model.service.mapper;

import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShoppingCartMapper {

    ShoppingCartMapper SHOPPING_CART_MAPPER_INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    ShoppingCartEntity dtoToEntity(ShoppingCartDto dto);

    Iterable<ShoppingCartEntity> dtoListToEntityList(Iterable<ShoppingCartDto> dto);

    ShoppingCartDto entityToDto(ShoppingCartEntity entity);

    Iterable<ShoppingCartDto> entityListToDtoList(Iterable<ShoppingCartEntity> entity);
}
