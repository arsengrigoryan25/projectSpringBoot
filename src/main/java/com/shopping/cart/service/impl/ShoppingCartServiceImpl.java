package com.shopping.cart.service.impl;

import com.shopping.cart.domain.dto.ShoppingCartDto;
import com.shopping.cart.domain.entity.ShoppingCartEntity;
import com.shopping.cart.mapper.ShoppingCartMapper;
import com.shopping.cart.repository.ShoppingCartRepository;
import com.shopping.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private  ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addProductInUserCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId(), shoppingCartDto.getQuantity());
        shoppingCartRepository.save(entity);
    }

    public void deleteProductInUserCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId(), shoppingCartDto.getQuantity());
        shoppingCartRepository.delete(entity);
    }

    public Iterable<ShoppingCartDto> findProductInUserCartByUserId(String userId) {
        return shoppingCartMapper.entityListToDtoList(shoppingCartRepository.findByUserId(userId));
    }
}