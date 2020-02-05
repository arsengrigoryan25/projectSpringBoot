package com.shopping.cart.model.service.impl;


import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;
import com.shopping.cart.model.service.mapper.ShoppingCartMapper;
import com.shopping.cart.model.repository.ShoppingCartRepository;
import com.shopping.cart.model.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCartDto createCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(),shoppingCartDto.getCartId());
        return shoppingCartMapper.entityToDto(shoppingCartRepository.save(entity));
    }

    @Override
    public ShoppingCartDto getCartByUserId(Long userId) {
        return shoppingCartMapper.entityToDto(shoppingCartRepository.findByUserId(userId));
    }

    @Override
    public Long deleteCartByUserId(Long userId) {
        shoppingCartRepository.deleteById(userId);
        return userId;
    }
}