package com.shopping.cart.model.service.impl;

import com.shopping.cart.model.domain.dto.CartItemDto;
import com.shopping.cart.model.domain.entity.CartItemEntity;
import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.model.exception.CustomRuntimeException;
import com.shopping.cart.model.repository.CartItemRepository;
import com.shopping.cart.model.service.CartItemService;
import com.shopping.cart.model.service.mapper.CartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private CartItemMapper cartItemMapper;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItemDto createItem(CartItemDto cartItem) {
        CartItemEntity entity = new CartItemEntity(cartItem.getProductId(),cartItem.getQuantity(),BasketItemsStatus.PENDING);
        return cartItemMapper.entityToDto(cartItemRepository.save(entity));
    }


    @Override
    public CartItemDto getItemsById(Long id) {
        return cartItemMapper.optionalEntityToDto(cartItemRepository.findById(id));
    }

    @Override
    public Iterable<CartItemDto> getAllPendingItems() {
        return cartItemMapper.entityListToDtoList(cartItemRepository.findByStatus(BasketItemsStatus.PENDING));
    }

    @Override
    public CartItemDto approvedItems(CartItemDto cartItemDto) {
        CartItemEntity entity = cartItemRepository.findById(cartItemDto.getId()).get();
        entity.setStatus(BasketItemsStatus.APPROVED);
        return cartItemMapper.entityToDto(cartItemRepository.save(entity));
    }

    @Override
    public CartItemDto deleteItem(CartItemDto cartItem) {
        try {
            CartItemEntity entity = new CartItemEntity(cartItem.getProductId());
            cartItemRepository.delete(entity);
        } catch (EmptyResultDataAccessException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.USER_NOT_FOUND);
        }
        return cartItem;
    }
}