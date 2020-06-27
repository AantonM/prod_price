package com.prodprice.prodprice_service.dao;

import com.prodprice.prodprice_service.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
