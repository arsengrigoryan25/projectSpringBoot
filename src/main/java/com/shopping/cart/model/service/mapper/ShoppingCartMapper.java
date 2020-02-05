package com.shopping.cart.model.service.mapper;

import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ShoppingCartMapper {
    ShoppingCartEntity dtoToEntity(ShoppingCartDto dto);
    Iterable<ShoppingCartEntity> dtoListToEntityList(Iterable<ShoppingCartDto> dto);
    ShoppingCartDto entityToDto(ShoppingCartEntity entity);
    Iterable<ShoppingCartDto> entityListToDtoList(Iterable<ShoppingCartEntity> entity);
}
