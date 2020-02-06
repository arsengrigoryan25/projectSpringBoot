package com.shopping.cart.model.service.impl;

import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;
import com.shopping.cart.model.repository.CartItemRepository;
import com.shopping.cart.model.repository.UserRepository;
import com.shopping.cart.model.service.mapper.CartItemMapper;
import com.shopping.cart.model.service.mapper.ShoppingCartMapper;
import com.shopping.cart.model.repository.ShoppingCartRepository;
import com.shopping.cart.model.service.ShoppingCartService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, CartItemRepository cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        shoppingCartMapper= Mappers.getMapper(ShoppingCartMapper.class);
    }

    @Override
    public ShoppingCartDto createCart(ShoppingCartDto dto) {

        ShoppingCartEntity entity = shoppingCartMapper.dtoToEntity(dto);
        userRepository.findById(dto.getId()).get().getItems().add(entity);
        cartItemRepository.findById(dto.getId()).get().setShoppingCart(entity);

        entity = shoppingCartRepository.save(entity);
        dto = shoppingCartMapper.entityToDto(entity);

        return dto;
    }

    @Override
    public ShoppingCartDto getItemsByUserId(Long userId) {

        ShoppingCartEntity entity = shoppingCartRepository.findByUserId(userId);
        ShoppingCartDto dto = shoppingCartMapper.entityToDto(entity);

        return dto;
    }

    @Override
    public ShoppingCartDto deleteItemsByCart(ShoppingCartDto dto) {

        ShoppingCartEntity entity = shoppingCartMapper.dtoToEntity(dto);
        userRepository.findById(dto.getId()).get().getItems().remove(entity);

        return dto;
    }
}