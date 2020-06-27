package com.prodprice.prodprice_service.service.impl;

import com.prodprice.prodprice_service.dao.PriceRepository;
import com.prodprice.prodprice_service.dao.ProductRepository;
import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.domain.entity.Product;
import com.prodprice.prodprice_service.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public List<PriceDTO> getProductPrices(Long prod_id)
    {
        if(!productRepository.existsById(prod_id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id not found");
        }

        return priceRepository.findPricesForProduct(prod_id)
                .stream()
                .map(price -> new PriceDTO(price.getDate_from(), price.getDate_to(), price.getPrice()))
                .collect(Collectors.toList());
    }
}
