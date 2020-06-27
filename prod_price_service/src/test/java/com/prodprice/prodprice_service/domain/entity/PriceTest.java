package com.prodprice.prodprice_service.domain.entity;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PriceTest
{
    private final Date DATE_FROM = new Date(1L);
    private final Date DATE_TO = new Date(1L);
    private final BigDecimal PRICE = BigDecimal.TEN;

    @Test
    public void testPojo()
    {
        PriceDTO priceTester = new PriceDTO(DATE_FROM, DATE_TO, PRICE);

        assertEquals(DATE_FROM, priceTester.getDate_from());
        assertEquals(DATE_TO, priceTester.getDate_to());
        assertEquals(PRICE, priceTester.getPrice());
    }
}
