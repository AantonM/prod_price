package com.prodprice.prodprice_service.domain.dto;

import com.prodprice.prodprice_service.domain.entity.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductDTOTest
{
    private final String PROD_NAME = "test";
    private final String PROD_DESC = "test";
    private final List<PriceDTO> PRICES = new ArrayList<>();
    private final int SCU = 123;

    @Test
    public void testPojo()
    {
        ProductDTO productTester = new ProductDTO(PROD_NAME, PROD_DESC, PRICES, SCU);

        assertEquals(PROD_NAME, productTester.getProd_name());
        assertEquals(PROD_DESC, productTester.getProd_desc());
        assertEquals(PRICES, productTester.getPrices());
        assertEquals(SCU, productTester.getScu());
    }

}
