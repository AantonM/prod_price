package com.prodprice.prodprice_service.service;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.domain.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PriceService
{
  /**
   * Fetch a list of all prices connected to the product with the provided id.
   *
   * @param prod_id the product id.
   * @return the list of prices connected to this product id.
   */
  List<PriceDTO> getProductPrices(Long prod_id);
}
