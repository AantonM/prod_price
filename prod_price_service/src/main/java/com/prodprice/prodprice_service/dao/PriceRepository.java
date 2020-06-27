package com.prodprice.prodprice_service.dao;

import com.prodprice.prodprice_service.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long>
{
    @Query(value = "SELECT * FROM prod_price.price WHERE product_id = :productId",  nativeQuery = true)
    List<Price> findPricesForProduct(@Param("productId") Long product_id);
}
