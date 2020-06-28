package com.prodprice.prodprice_service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Data
public class PriceDTO
{
    private Date date_from;

    private Date date_to;

    BigDecimal price;
}
