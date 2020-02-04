package com.shopping.cart.model.service.impl;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.domain.entity.ProductEntity;
import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.exception.CustomRuntimeException;
import com.shopping.cart.model.filter.ProductFilter;
//import com.shopping.cart.model.filter.SortFilter;
import com.shopping.cart.model.service.mapper.ProductMapper;
import com.shopping.cart.model.repository.ProductRepository;
import com.shopping.cart.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity creatProduct(ProductDto product) {
        ProductEntity entity = new ProductEntity(product.getName(), product.getType(), product.getPrice(), product.getAddedDate(),
                null, product.getCountInStock());
        return productRepository.save(entity);
    }

    public Long deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.PRODUCT_NOT_FOUND);
        }
        return id;
    }

    public ProductEntity updateProducts(ProductDto productDto) {
        ProductEntity entity = productRepository.findById(productDto.getId()).get();
        entity.setName(productDto.getName());
        entity.setType(productDto.getType());
        entity.setPrice(productDto.getPrice());
        entity.setUpdatedDate(new Date());
        entity.setCountInStock(productDto.getCountInStock());
        return productRepository.save(entity);
    }

    public Iterable<ProductDto> getAllProducts() {
        return productMapper.entityListToDtoList(productRepository.findAll());
    }

    public Iterable<ProductDto> getProductsByFilter(ProductFilter filter) {
        String name = filter.getName();
        Integer fromPrice = filter.getFromPrice();
        Integer toPrice = filter.getToPrice();
        String type = filter.getType();
        return productMapper.entityListToDtoList(productRepository.findByNameAndPriceAndType(name, fromPrice, toPrice, type));
    }

//    public Iterable<ProductDto> sortProducts(SortFilter filter) {
//        return productMapper.entityListToDtoList(productRepository.findAll(PageRequest.of(filter.getPage(), filter.getSize(), Sort.by(filter.getSortedValue()))));
//    }
}