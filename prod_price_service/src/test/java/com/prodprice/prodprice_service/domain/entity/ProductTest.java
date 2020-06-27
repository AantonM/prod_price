package com.prodprice.prodprice_service.domain.entity;

import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest
{
    private final Long ID = 1L;
    private final String PROD_NAME = "test";
    private final String PROD_DESC = "test";
    private final List<Price> PRICES = new ArrayList<>();
    private final int SCU = 123;

    @Test
    public void testPojo()
    {
        Product productTester = new Product(PROD_NAME, PRICES, SCU);

        assertEquals(PROD_NAME, productTester.getProd_name());
        assertEquals(PRICES, productTester.getPrices());
        assertEquals(SCU, productTester.getScu());
    }

    @Test
    public void testPojo_getset()
    {
        Product productTester = new Product(PROD_NAME, PRICES, SCU);
        productTester.setProd_desc(PROD_DESC);
        productTester.setId(ID);

        assertEquals(PROD_NAME, productTester.getProd_name());
        assertEquals(PRICES, productTester.getPrices());
        assertEquals(SCU, productTester.getScu());
        assertEquals(PROD_DESC, productTester.getProd_desc());
        assertEquals(ID, productTester.getId());
    }

}
