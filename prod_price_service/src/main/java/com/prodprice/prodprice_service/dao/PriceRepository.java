package com.prodprice.prodprice_service.dao;

import com.prodprice.prodprice_service.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository corresponding to the <b>prod_price.price</b> table
 */
public interface PriceRepository extends JpaRepository<Price, Long>
{
    /**
     * Fetch all prices that are connected to a product with the provided id.
     *
     * @param product_id the product id
     * @return a list of all prices connected to this product.
     */
    @Query(value = "SELECT * FROM prod_price.price WHERE product_id = :productId",  nativeQuery = true)
    List<Price> findPricesForProduct(@Param("productId") Long product_id);
}
