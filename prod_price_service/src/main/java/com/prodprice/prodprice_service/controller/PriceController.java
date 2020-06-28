package com.prodprice.prodprice_service.controller;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Price controller, responsible for the price domain.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product/{productId}")
public class PriceController
{
    private final PriceService priceService;

    /**
     * Construct price.
     *
     * @param priceService the price service
     */
    public PriceController(PriceService priceService)
    {
        this.priceService = priceService;
    }

    /**
     * Fetch the prices related to the product with the given id.
     *
     * @param id the product id.
     * @return all prices related to the product with the provided id.
     */
    @GetMapping(value = "/price", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<PriceDTO> getProductPrices(@PathVariable Long productId)
    {
        return priceService.getProductPrices(productId);
    }
}
