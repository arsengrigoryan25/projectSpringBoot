package com.shopping.cart.service.mapper;

import com.shopping.cart.domain.dto.ProductDto;
import com.shopping.cart.domain.entity.ProductEntity;
import org.mapstruct.Mapper;


@Mapper
public interface ProductMapper {
    ProductEntity dtoToEntity(ProductDto dto);
    Iterable<ProductEntity> dtoListToEntityList(Iterable<ProductDto> dto);
    ProductDto entityToDto(ProductEntity entity);
    Iterable<ProductDto> entityListToDtoList(Iterable<ProductEntity> entity);
}

//public class SimpleSourceDestinationMapperImpl implements SimpleSourceDestinationMapper {
//    @Override
//    public SimpleDestination sourceToDestination(SimpleSource source) {
//        if ( source == null ) {
//            return null;
//        }
//        SimpleDestination simpleDestination = new SimpleDestination();
//        simpleDestination.setName( source.getName() );
//        simpleDestination.setDescription( source.getDescription() );
//        return simpleDestination;
//    }
//    @Override
//    public SimpleSource destinationToSource(SimpleDestination destination){
//        if ( destination == null ) {
//            return null;
//        }
//        SimpleSource simpleSource = new SimpleSource();
//        simpleSource.setName( destination.getName() );
//        simpleSource.setDescription( destination.getDescription() );
//        return simpleSource;
//    }
//}