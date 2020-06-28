package com.prodprice.prodprice_service.service;

import com.prodprice.prodprice_service.domain.dto.ProductDTO;

public interface ProductService
{

    /**
     * Get the product corresponding to the provided id.
     *
     * @param productId the product id.
     * @return the product that corresponds to the provided id.
     */
    ProductDTO getProduct(Long productId);
}
