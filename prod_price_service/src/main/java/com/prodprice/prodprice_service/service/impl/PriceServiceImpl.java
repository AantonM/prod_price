package com.prodprice.prodprice_service.service.impl;

import com.prodprice.prodprice_service.dao.PriceRepository;
import com.prodprice.prodprice_service.dao.ProductRepository;
import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Price service layer. Provides the ability to work with prices.
 */
@Service
@Slf4j
public class PriceServiceImpl implements PriceService
{
    private final PriceRepository priceRepository;
    private final ProductRepository productRepository;

    /**
     * Construct Price service.
     *
     * @param priceRepository   a price repository.
     * @param productRepository a product repository.
     */
    public PriceServiceImpl(PriceRepository priceRepository, ProductRepository productRepository)
    {
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
    }

    /**
     * Fetch a list of all prices connected to the product with the provided id.
     *
     * @param prod_id the product id.
     * @return the list of prices connected to this product id.
     */
    @Override
    public List<PriceDTO> getProductPrices(Long prod_id)
    {
        if (!productRepository.existsById(prod_id))
        {
            log.error("404: Product id not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id not found");
        }

        log.info("Fetching prices for product with id:{}", prod_id);
        return priceRepository.findPricesForProduct(prod_id)
                .stream()
                .map(price -> new PriceDTO(price.getDate_from(), price.getDate_to(), price.getPrice()))
                .collect(Collectors.toList());
    }
}
