package com.shopping.cart.model.service;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.domain.entity.ProductEntity;
import com.shopping.cart.model.filter.ProductFilter;
//import com.shopping.cart.model.filter.SortFilter;


public interface ProductService {

    public ProductEntity creatProduct(ProductDto product);

    public Long deleteProduct(Long id);

    public ProductEntity updateProducts(ProductDto productDto);

    public Iterable<ProductDto> getAllProducts();

    public Iterable<ProductDto> getProductsByFilter(ProductFilter filter);

//    public Iterable<ProductDto> sortProducts(SortFilter filter) ;
}