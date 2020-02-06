package com.shopping.cart.service.impl;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.domain.entity.ProductEntity;
import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.exception.CustomRuntimeException;
import com.shopping.cart.model.filter.ProductFilter;
import com.shopping.cart.service.mapper.ProductMapper;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.service.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productMapper= Mappers.getMapper(ProductMapper.class);
    }

    public ProductDto creatProduct(ProductDto dto) {

        ProductEntity entity = productMapper.dtoToEntity(dto);
        entity = productRepository.save(entity);

        dto = productMapper.entityToDto(entity);
        return dto;
    }

    public Long deleteProduct(Long id) {

        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.PRODUCT_NOT_FOUND);
        }

        return id;
    }

    public ProductDto updateProducts(ProductDto dto) {

        ProductEntity entity = productRepository.findById(dto.getId()).get();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setPrice(dto.getPrice());
        entity.setUpdatedDate(new Date());
        entity.setCountInStock(dto.getCountInStock());
        entity = productRepository.save(entity);

        dto = productMapper.entityToDto(entity);

        return dto;
    }

    public Iterable<ProductDto> getAllProducts() {

        Iterable<ProductEntity> productEntities = productRepository.findAll();
        Iterable<ProductDto> dtoList = productMapper.entityListToDtoList(productEntities);

        return dtoList;
    }

    public Iterable<ProductDto> getProductsByFilter(ProductFilter filter) {

        String name = filter.getName();
        Integer fromPrice = filter.getFromPrice();
        Integer toPrice = filter.getToPrice();
        String type = filter.getType();

        Iterable<ProductEntity> entities = productRepository.findByNameAndPriceAndType(name, fromPrice, toPrice, type);
        Iterable<ProductDto> dtoList = productMapper.entityListToDtoList(entities);

        return dtoList;
    }

//    public Iterable<ProductDto> sortProducts(SortFilter filter) {
//        return productMapper.entityListToDtoList(productRepository.findAll(PageRequest.of(filter.getPage(), filter.getSize(), Sort.by(filter.getSortedValue()))));
//    }
}