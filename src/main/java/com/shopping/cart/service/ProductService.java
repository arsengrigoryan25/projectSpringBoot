package com.shopping.cart.service;

import com.shopping.cart.domain.dto.Product;
import com.shopping.cart.domain.entity.ProductEntity;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity creatProducts(Product product) {
        ProductEntity entity = new ProductEntity(product.getName(), product.getType(), product.getPrice(),
                product.getAddedDate(), null, product.getCountInStock());
        return productRepository.save(entity);
    }

    public void deleteProduct(String id) {
        //TODO petqa chshtel ashxatum e te voch
        Integer id1 = new Integer(id);
        productRepository.deleteById(id1);
    }

    public void updateProducts(Product product) {
        try {
            ProductEntity entity = productRepository.findById(product.getId()).get(); //TODO petqa chshtel ashxatum e te voch
            entity.setName(product.getName());
            entity.setType(product.getType());
            entity.setPrice(product.getPrice());
            entity.setUpdatedDate(new Date());
            entity.setCountInStock(product.getCountInStock());
            productRepository.save(entity);
        } catch (Exception e) {

        }
    }

    public Iterable<ProductEntity> searchAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity searchProductsByFilter(ProductFilter filter) {
        // TODO sorting
        return productRepository.findByNameAndPriceAndType(filter.getName(), filter.getPrice(), filter.getType());
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
