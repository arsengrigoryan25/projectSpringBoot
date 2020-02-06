package com.shopping.cart.service.impl;

import com.shopping.cart.model.domain.dto.CartItemDto;
import com.shopping.cart.model.domain.entity.CartItemEntity;
import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.exception.CustomRuntimeException;
import com.shopping.cart.repository.CartItemRepository;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.service.CartItemService;
import com.shopping.cart.service.mapper.CartItemMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CartItemMapper cartItemMapper;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        cartItemMapper = Mappers.getMapper(CartItemMapper.class);
    }

    @Override
    public CartItemDto createItem(CartItemDto dto) {

        CartItemEntity entity = cartItemMapper.dtoToEntity(dto);

        productRepository.findById(entity.getId()).get().getCartItem().add(entity);
        CartItemEntity cartItem = cartItemRepository.save(entity);
        CartItemDto cartItemDto = cartItemMapper.entityToDto(cartItem);

        return cartItemDto;
    }

    @Override
    public CartItemDto getItemsById(Long id) {

        Optional<CartItemEntity> cartItemDto = cartItemRepository.findById(id);
        CartItemDto cartItem = cartItemMapper.optionalEntityToDto(cartItemDto);

        return cartItem;
    }

    @Override
    public Iterable<CartItemDto> getAllPendingItems() {

        Set<CartItemEntity> cartItemEntity = cartItemRepository.findByStatus(BasketItemsStatus.PENDING);
        Iterable<CartItemDto> cartItems = cartItemMapper.entityListToDtoList(cartItemEntity);

        return cartItems;
    }

    @Override
    public CartItemDto approvedItems(CartItemDto cartItemDto) {

        CartItemEntity entity = cartItemRepository.findById(cartItemDto.getId()).get();
        entity.setStatus(BasketItemsStatus.APPROVED);
        entity = cartItemRepository.save(entity);

        CartItemDto cartItem = cartItemMapper.entityToDto(entity);

        return cartItem;
    }

    @Override
    public CartItemDto deleteItem(CartItemDto dto) {

        try {
            CartItemEntity entity = cartItemMapper.dtoToEntity(dto);
            productRepository.findById(dto.getId()).get().getCartItem().remove(entity);
            cartItemRepository.delete(entity);
        } catch (EmptyResultDataAccessException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.USER_NOT_FOUND);
        }
        return dto;
    }
}