package com.prodprice.prodprice_service.controller;

import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController
{

    ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<ProductDTO> getProduct(@PathVariable Long id)
    {
        return productService.getProduct(id);
    }
}
