package com.shopping.cart.service.impl;

import com.shopping.cart.BasketItemsStatus;
import com.shopping.cart.domain.dto.ShoppingCartDto;
import com.shopping.cart.domain.entity.ProductEntity;
import com.shopping.cart.domain.entity.ShoppingCartEntity;
import com.shopping.cart.service.mapper.ShoppingCartMapper;
import com.shopping.cart.repository.ShoppingCartRepository;
import com.shopping.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addProductInUserCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId(), shoppingCartDto.getQuantity(),
                BasketItemsStatus.PENDING);
        shoppingCartRepository.save(entity);
    }

    @Override
    public Iterable<ShoppingCartDto> getProductByUserId(Long userId) {
        return shoppingCartMapper.entityListToDtoList(shoppingCartRepository.findByUserId(userId));
    }

    @Override
    public Iterable<ShoppingCartDto> getPendingProduct(Long userId) {
        return shoppingCartMapper.entityListToDtoList(shoppingCartRepository.findByUserIdAndStatus(userId,BasketItemsStatus.PENDING));
    }

    @Override
    public void approvedProduct(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = shoppingCartRepository.findById(shoppingCartDto.getId()).get();
        entity.setStatus(BasketItemsStatus.APPROVED);
        shoppingCartRepository.save(entity);
    }

    @Override
    public void deleteProductInUserCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId());
        shoppingCartRepository.delete(entity);
    }




}