package com.prodprice.prodprice_service.service;

import com.prodprice.prodprice_service.domain.dto.ProductDTO;

import java.util.List;

public interface ProductService
{

    ProductDTO getProduct(Long productId);
}
