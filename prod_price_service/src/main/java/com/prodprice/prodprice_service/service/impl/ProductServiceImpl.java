package com.prodprice.prodprice_service.service.impl;

import com.prodprice.prodprice_service.dao.ProductRepository;
import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService
{

    ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProduct(Long productId)
    {

        log.info("Fetching product info for product with id:{}", productId);
        return productRepository.findById(productId)
                .map(product -> new ProductDTO(product.getProd_name(), product.getProd_desc(),
                        product.getPrices().stream()
                                .map(price -> new PriceDTO(price.getDate_from(), price.getDate_to(), price.getPrice())).collect(Collectors.toList()),
                        product.getScu()))
                .orElseThrow(() -> {
                    log.error("Product id not found");
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id not found");
                });
    }
}
