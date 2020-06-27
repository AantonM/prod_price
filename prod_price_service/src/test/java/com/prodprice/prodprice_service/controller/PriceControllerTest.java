package com.prodprice.prodprice_service.controller;

import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.service.PriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceControllerTest
{
    @Mock
    PriceService service;

    @InjectMocks
    PriceController controller;

    @Test
    public void test_getProductPrices()
    {
        List<PriceDTO> expected = Arrays.asList(new PriceDTO(new Date(1L), new Date(1L), BigDecimal.TEN));

        when(service.getProductPrices(any())).thenReturn(expected);
        List<PriceDTO> actual = controller.getProductPrices(1L);

        verify(service).getProductPrices(1L);
        assertEquals(new Date(1L), actual.get(0).getDate_from());
        assertEquals(new Date(1L), actual.get(0).getDate_to());
        assertEquals(BigDecimal.TEN, actual.get(0).getPrice());
    }
}
