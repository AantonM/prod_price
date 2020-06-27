package com.prodprice.prodprice_service.service.impl;

import com.prodprice.prodprice_service.dao.ProductRepository;
import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService
{

    ProductRepository  productRepository;

    ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getProduct(Long productId)
    {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDTO(product.getId(), product.getProd_name(), product.getProd_desc(), product.getPrices(), product.getScu()))
                .collect(Collectors.toList());
    }
}
