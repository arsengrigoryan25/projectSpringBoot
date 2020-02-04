package com.shopping.cart.model.service.impl;

import com.shopping.cart.model.domain.enums.BasketItemsStatus;
import com.shopping.cart.model.domain.dto.ShoppingCartDto;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;
import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.exception.CustomRuntimeException;
import com.shopping.cart.model.service.mapper.ShoppingCartMapper;
import com.shopping.cart.model.repository.ShoppingCartRepository;
import com.shopping.cart.model.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCartEntity addProductInUserCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId(), shoppingCartDto.getQuantity(),
                BasketItemsStatus.PENDING);
        return shoppingCartRepository.save(entity);
    }

    @Override
    public Iterable<ShoppingCartDto> getProductByUserId(Long userId) {
        return shoppingCartMapper.entityListToDtoList(shoppingCartRepository.findByUserId(userId));
    }

    @Override
    public Iterable<ShoppingCartDto> getPendingProduct(Long userId) {
        return shoppingCartMapper.entityListToDtoList(shoppingCartRepository.findByUserIdAndStatus(userId, BasketItemsStatus.PENDING));
    }

    @Override
    public ShoppingCartEntity approvedProduct(ShoppingCartDto shoppingCartDto) {
        ShoppingCartEntity entity = shoppingCartRepository.findById(shoppingCartDto.getId()).get();
        entity.setStatus(BasketItemsStatus.APPROVED);
        return shoppingCartRepository.save(entity);
    }

    @Override
    public void deleteProductInUserCart(ShoppingCartDto shoppingCartDto) {
        try {
            ShoppingCartEntity entity = new ShoppingCartEntity(shoppingCartDto.getUserId(), shoppingCartDto.getProductId());
            shoppingCartRepository.delete(entity);
        } catch (EmptyResultDataAccessException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.USER_NOT_FOUND);
        }
    }
}