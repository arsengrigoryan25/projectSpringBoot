package com.shopping.cart.service.mapper;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    Iterable<UserEntity> dtoListToEntityList(Iterable<UserDto> dto);
    UserEntity dtoToEntity(UserDto dto);
    Iterable<UserDto> entityListToDtoList(Iterable<UserEntity> entity);
    UserDto entityToDto(UserEntity entity);
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