package com.prodprice.prodprice_service.domain.dto;

import com.prodprice.prodprice_service.domain.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ProductDTO
{
    private Long id;
    private String prod_name;
    private String prod_desc;
    private List<Price> prices;
    private int scu;
}
