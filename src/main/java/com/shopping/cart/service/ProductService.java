package com.shopping.cart.service;

import com.shopping.cart.domain.dto.ProductDto;
import com.shopping.cart.domain.entity.ProductEntity;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.filter.SortFilter;
import java.util.List;


public interface ProductService {

    public void creatProduct(ProductDto product) ;

    public String deleteProduct(Integer id) ;

    public void updateProducts(ProductDto productDto) ;

    public Iterable<ProductEntity> getAllProducts() ;

    public List<ProductEntity> searchProductsByFilter(ProductFilter filter) ;

    public List<ProductEntity> sortProducts(SortFilter filter) ;
}