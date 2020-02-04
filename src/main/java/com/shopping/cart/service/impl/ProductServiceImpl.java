package com.shopping.cart.service.impl;

import com.shopping.cart.domain.dto.ProductDto;
import com.shopping.cart.domain.entity.ProductEntity;
import com.shopping.cart.enums.ErrorMessageEnum;
import com.shopping.cart.exception.MyException;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.filter.SortFilter;
import com.shopping.cart.service.mapper.ProductMapper;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public void creatProduct(ProductDto product) {
        ProductEntity entity = new ProductEntity(product.getName(), product.getType(), product.getPrice(), product.getAddedDate(),
                null, product.getCountInStock());
        productRepository.save(entity);
    }

    public String deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new MyException(ErrorMessageEnum.PRODUCT_NOT_FOUND);
        }
        return "Product is deleted";
    }

    public void updateProducts(ProductDto productDto) {
        ProductEntity entity = productRepository.findById(productDto.getId()).get();
        entity.setName(productDto.getName());
        entity.setType(productDto.getType());
        entity.setPrice(productDto.getPrice());
        entity.setUpdatedDate(new Date());
        entity.setCountInStock(productDto.getCountInStock());
        productRepository.save(entity);
    }

    public Iterable<ProductDto> getAllProducts() {
        return productMapper.entityListToDtoList(productRepository.findAll());
    }

    public Iterable<ProductDto> searchProductsByFilter(ProductFilter filter) {
        String name = filter.getName();
        Integer price = filter.getPrice();
        String type = filter.getType();
        return productMapper.entityListToDtoList(productRepository.findByNameAndPriceAndType(name, price, type));
    }

    public Iterable<ProductDto> sortProducts(SortFilter filter) {
        return productMapper.entityListToDtoList(productRepository.findAll(PageRequest.of(filter.getPage(), filter.getSize(), Sort.by(filter.getSortedValue()))));
    }

}