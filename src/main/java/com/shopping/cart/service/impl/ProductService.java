package com.shopping.cart.service.impl;

import com.shopping.cart.domain.dto.ProductDto;
import com.shopping.cart.domain.entity.ProductEntity;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.filter.SortFilter;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void creatProduct(ProductDto product) {
        ProductEntity entity = new ProductEntity(product.getName(), product.getType(), product.getPrice(), product.getAddedDate(),
                null, product.getCountInStock());
        productRepository.save(entity);
    }

    public String deleteProduct(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "Product not found";
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

    public Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductEntity> searchProductsByFilter(ProductFilter filter) {
        String name = filter.getName();
        Integer price = filter.getPrice();
        String type = filter.getType();
        return productRepository.findByNameAndPriceAndType(name, price, type);
    }

    public List<ProductEntity> sortProducts(SortFilter filter) {
        return productRepository.findAll(PageRequest.of(filter.getPage(), filter.getSize(), Sort.by(filter.getSortedValue())));
    }

}

//• Пользователь может просматривать все продукты, выполнять фильтрацию по названию, цене (по убыванию) и по типу

//    String sql = " UPDATE product " +
//            "SET type = ?," +
//            "    price = ?," +
//            "    countInStock = ?" +
//            "WHERE id = ?";
//
//        jdbcTemplate.update(sql,
//                product.getName(),
//                product.getPrice(),
//                product.getType(),
//                product.getCountInStock(),
//                product.getId());
