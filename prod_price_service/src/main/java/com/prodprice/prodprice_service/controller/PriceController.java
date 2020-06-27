package com.prodprice.prodprice_service.controller;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.domain.entity.Price;
import com.prodprice.prodprice_service.domain.entity.Product;
import com.prodprice.prodprice_service.service.PriceService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product/{productId}")
public class PriceController
{
  private final PriceService priceService;

  public PriceController(PriceService priceService)
  {
    this.priceService = priceService;
  }

  @GetMapping(value = "/price", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody List<PriceDTO> getProductPrices(@PathVariable Long productId)
  {
    return priceService.getProductPrices(productId);
  }
}
