package com.shopping.cart.mapper;

import com.shopping.cart.domain.dto.ProductDto;
import com.shopping.cart.domain.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductEntity dtoToEntity(ProductDto source);
    ProductDto entityToDto(ProductEntity destination);
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