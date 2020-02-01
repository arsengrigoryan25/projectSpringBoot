package com.shopping.cart.repository;

import com.shopping.cart.domain.dto.Product;
import com.shopping.cart.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where (:name is null or p.name = :name) " +
                                            "and (:price is null or p.price = :price) " +
                                            "and (:type is null or p.type = :type) ")
    ProductEntity findByNameAndPriceAndType(@Param("name")String name, @Param("price") Integer price, @Param("type") String type);

//    ProductEntity findByNameAndPriceAndType(String name, String price, String type);
//    ProductEntity findByName(String name);
//    ProductEntity findByPrice(String price);
//    ProductEntity findByType(String type);
}
