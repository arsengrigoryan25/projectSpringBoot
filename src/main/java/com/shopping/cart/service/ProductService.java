package com.shopping.cart.service;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.filter.ProductFilter;

public interface ProductService {

    ProductDto creatProduct(ProductDto product);

    Long deleteProduct(Long id);

    ProductDto updateProducts(ProductDto productDto);

    Iterable<ProductDto> getAllProducts();

    Iterable<ProductDto> getProductsByFilter(ProductFilter filter);
}