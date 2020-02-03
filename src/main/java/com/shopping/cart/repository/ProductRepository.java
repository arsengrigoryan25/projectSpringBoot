package com.shopping.cart.repository;

import com.shopping.cart.domain.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import static org.springframework.data.domain.Sort.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("select p from ProductEntity p where (:name is null or p.name = :name) " +
                                            "and (:price is null or p.price = :price) " +
                                            "and (:type is null or p.type = :type) ")
    List<ProductEntity> findByNameAndPriceAndType(@Param("name")String name, @Param("price") Integer price, @Param("type") String type);

    List<ProductEntity> findAll(Pageable pageable);
}
