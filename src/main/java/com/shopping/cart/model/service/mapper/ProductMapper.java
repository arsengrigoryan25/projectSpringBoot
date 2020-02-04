package com.shopping.cart.model.service.mapper;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.domain.entity.ProductEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper {
    ProductEntity dtoToEntity(ProductDto dto);
    Iterable<ProductEntity> dtoListToEntityList(Iterable<ProductDto> dto);
    ProductDto entityToDto(ProductEntity entity);
    Iterable<ProductDto> entityListToDtoList(Iterable<ProductEntity> entity);
}