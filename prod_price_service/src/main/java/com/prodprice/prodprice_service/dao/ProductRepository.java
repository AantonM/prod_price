package com.prodprice.prodprice_service.dao;

import com.prodprice.prodprice_service.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository corresponding to the <b>prod_price.product</b> table
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{
}
