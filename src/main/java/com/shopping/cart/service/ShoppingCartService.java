package com.shopping.cart.service;

import com.shopping.cart.domain.dto.ShoppingCartDto;
import com.shopping.cart.domain.entity.ShoppingCartEntity;
import com.shopping.cart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;

public interface ShoppingCartService {

    public void addProductInUserCart(ShoppingCartDto shoppingCartDto) ;

    public void deleteProductInUserCart(ShoppingCartDto shoppingCartDto);

    public Iterable<ShoppingCartDto> findProductInUserCartByUserId(String userId) ;
}