package com.prodprice.prodprice_service.service;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import org.springframework.data.domain.Page;

public interface PriceService
{
  Page<PriceDTO> getProductPrices(Long prod_id, int page, int size, String sortBy, String desc);

}
