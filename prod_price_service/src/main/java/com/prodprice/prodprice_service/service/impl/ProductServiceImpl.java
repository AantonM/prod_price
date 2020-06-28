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

/**
 * Product service layer. Provides the ability to work with prices.
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService
{

    ProductRepository productRepository;

    /**
     * Construct product service.
     *
     * @param productRepository a product repository.
     */
    ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    /**
     * Get the product corresponding to the provided id.
     *
     * @param productId the product id.
     * @return the product that corresponds to the provided id.
     */
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
