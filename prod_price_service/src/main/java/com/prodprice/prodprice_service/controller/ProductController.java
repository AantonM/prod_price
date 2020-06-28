package com.prodprice.prodprice_service.controller;

import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Product controller, responsible for the product domain.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController
{

    ProductService productService;

    /**
     * Construct product.
     *
     * @param productService the product service
     */
    ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    /**
     * Fetch the product responding to a given id.
     *
     * @param id the product id.
     * @return the product responding to the given id.
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ProductDTO getProduct(@PathVariable Long id)
    {
        return productService.getProduct(id);
    }
}
