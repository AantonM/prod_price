package com.prodprice.prodprice_service.service;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.domain.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PriceService
{
  List<PriceDTO> getProductPrices(Long prod_id);
}
