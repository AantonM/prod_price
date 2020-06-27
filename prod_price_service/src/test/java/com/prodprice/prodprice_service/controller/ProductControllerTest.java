package com.prodprice.prodprice_service.controller;

import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest
{

    @Mock
    ProductService service;

    @InjectMocks
    ProductController controller;

    @Test
    public void test_getProduct()
    {
        ProductDTO expected =new ProductDTO("test", "test", null, 123);

        when(service.getProduct(any())).thenReturn(expected);
        ProductDTO actual = controller.getProduct(1L);

        verify(service).getProduct(1L);

        assertEquals("test", actual.getProd_name());
        assertEquals("test", actual.getProd_desc());
        assertNull(actual.getPrices());
        assertEquals(123, actual.getScu());
    }
}
