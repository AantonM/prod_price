package com.prodprice.prodprice_service.controller;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.domain.entity.Price;
import com.prodprice.prodprice_service.service.PriceService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/price")
public class PriceController
{
  private final PriceService priceService;

  public PriceController(PriceService priceService)
  {
    this.priceService = priceService;
  }

  @GetMapping(value = "/{id}", produces = "application/json", params = {"page", "size", "sortBy", "type"})
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody Page<PriceDTO> getProductPrices(@PathVariable Long id, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sortBy") String sortBy, @RequestParam("type") String sortType)
  {
    return priceService.getProductPrices(id, page, size, sortBy, sortType);
  }
}
