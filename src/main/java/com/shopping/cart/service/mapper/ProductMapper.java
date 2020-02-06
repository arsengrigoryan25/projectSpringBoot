package com.shopping.cart.service.mapper;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.domain.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER_INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity dtoToEntity(ProductDto dto);

    Iterable<ProductEntity> dtoListToEntityList(Iterable<ProductDto> dto);

    ProductDto entityToDto(ProductEntity entity);

    Iterable<ProductDto> entityListToDtoList(Iterable<ProductEntity> entity);
}



