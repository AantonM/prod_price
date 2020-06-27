package com.prodprice.prodprice_service.service;

import com.prodprice.prodprice_service.dao.PriceRepository;
import com.prodprice.prodprice_service.dao.ProductRepository;
import com.prodprice.prodprice_service.domain.dto.PriceDTO;
import com.prodprice.prodprice_service.domain.entity.Price;
import com.prodprice.prodprice_service.service.impl.PriceServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceImplTest
{
    Fixture fixture;

    @Before
    public void setup()
    {
        fixture = new Fixture();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void test_getProductPrices_validProdId_ReturnsPrices()
    {
        fixture.givenProduct();
        fixture.givenPrices();
        List<PriceDTO> result =  fixture.whenGetProductPricesCalled();
        fixture.thenPricesAreReturned(result);
    }

    @Test
    public void test_getProductPrices_invalidProdId_throw404()
    {
        exceptionRule.expect(ResponseStatusException.class);
        exceptionRule.expectMessage("404 NOT_FOUND \"Product id not found\"");
        fixture.givenProductDoesNotExist();
        fixture.whenGetProductPricesCalled();
    }

    private class Fixture
    {
        @Mock
        PriceRepository priceRepository;
        @Mock
        ProductRepository productRepository;
        @InjectMocks
        PriceServiceImpl priceService;

        Fixture()
        {
            MockitoAnnotations.initMocks(this);
        }

        public void givenProduct()
        {
            when(productRepository.existsById(any())).thenReturn(true);
        }

        public void givenPrices()
        {
            Price price1 = new Price(new Date(1L), new Date(1L), BigDecimal.TEN);
            Price price2 = new Price(new Date(2L), new Date(2L), BigDecimal.ZERO);

            when(priceRepository.findPricesForProduct(any())).thenReturn(Arrays.asList(price1, price2));
        }


        public void givenProductDoesNotExist()
        {
            when(productRepository.existsById(any())).thenReturn(false);
        }

        public List<PriceDTO> whenGetProductPricesCalled()
        {
            return priceService.getProductPrices(any());
        }

        public void thenPricesAreReturned(List<PriceDTO> result)
        {
            assertEquals(2, result.size());
            assertEquals(new Date(1L), result.get(0).getDate_from());
            assertEquals(new Date(1L), result.get(0).getDate_to());
            assertEquals(BigDecimal.TEN, result.get(0).getPrice());

            assertEquals(new Date(2L), result.get(1).getDate_from());
            assertEquals(new Date(2L), result.get(1).getDate_to());
            assertEquals(BigDecimal.ZERO, result.get(1).getPrice());
        }

    }
}
