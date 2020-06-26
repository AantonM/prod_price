package com.prodprice.prodprice_service.service.impl;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.dao.PriceRepository;
import com.prodprice.prodprice_service.dao.ProductRepository;
import com.prodprice.prodprice_service.service.PriceService;
import org.springframework.data.domain.Page;

public class PriceServiceImpl implements PriceService
{
    private final PriceRepository priceRepository;
    private final ProductRepository productRepository;

  public PriceServiceImpl(PriceRepository priceRepository, ProductRepository productRepository)
  {
    this.priceRepository = priceRepository;
    this.productRepository = productRepository;
  }


  @Override
  public Page<PriceDTO> getProductPrices(Long prod_id, int page, int size, String sortBy, String desc)
  {
    productRepository.findById(prod_id);
  }
}
