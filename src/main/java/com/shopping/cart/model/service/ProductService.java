package com.shopping.cart.model.service;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.filter.ProductFilter;


public interface ProductService {

    public ProductDto creatProduct(ProductDto product);
    public Long deleteProduct(Long id);
    public ProductDto updateProducts(ProductDto productDto);
    public Iterable<ProductDto> getAllProducts();
    public Iterable<ProductDto> getProductsByFilter(ProductFilter filter);
//    public Iterable<ProductDto> sortProducts(SortFilter filter) ;
}