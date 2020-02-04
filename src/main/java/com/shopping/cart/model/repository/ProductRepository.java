package com.shopping.cart.model.repository;

import com.shopping.cart.model.domain.entity.ProductEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query(" select p from ProductEntity p " +
            " where (:name is null or p.name = :name) " +
            "   and (:price is null or p.price >= :fromPrice and p.price < :toPrice) " +
            "   and (:type is null or p.type = :type) " +
            " order by p.price desc")
    List<ProductEntity> findByNameAndPriceAndType(@Param("name") String name, @Param("fromPrice") Integer fromPrice,
                                                  @Param("toPrice") Integer toPrice, @Param("type") String type);

//    List<ProductEntity> findAll(Pageable pageable);
}