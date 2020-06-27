package com.prodprice.prodprice_service.service;

import com.prodprice.prodprice_service.dao.ProductRepository;
import com.prodprice.prodprice_service.domain.dto.ProductDTO;
import com.prodprice.prodprice_service.domain.entity.Price;
import com.prodprice.prodprice_service.domain.entity.Product;
import com.prodprice.prodprice_service.service.impl.ProductServiceImpl;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest
{
    Fixture fixture;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setup()
    {
        fixture = new Fixture();
    }

    @Test
    public void test_getProduct_validProdId_returnsProduct()
    {
        fixture.givenProduct();
        ProductDTO result = fixture.whenGetProductIsCalled();
        fixture.thenProductIsReturned(result);
    }

    @Test
    public void test_getProduct_invalidProdId_throw404()
    {
        exceptionRule.expect(ResponseStatusException.class);
        exceptionRule.expectMessage("404 NOT_FOUND \"Product id not found\"");
        fixture.givenNoProduct();
        fixture.whenGetProductIsCalled();
    }

    private class Fixture
    {
        @Mock
        ProductRepository productRepository;
        @InjectMocks
        ProductServiceImpl service;

        private final String PROD_NAME = "Test";
        private final Date DATE_1 = new Date(1L);
        private final Date DATE_2 = new Date(2L);
        private final Date DATE_3 = new Date(3L);
        private final Date DATE_4 = new Date(4L);
        private final BigDecimal PRICE_1 = BigDecimal.ONE;
        private final BigDecimal PRICE_10 = BigDecimal.TEN;
        private final int SCU = 123;

        Fixture()
        {
            MockitoAnnotations.initMocks(this);
        }

        public void givenProduct()
        {
            Price price1 = new Price(DATE_1, DATE_2, PRICE_1);
            Price price2 = new Price(DATE_3, DATE_4, PRICE_10);

            Product product = new Product(PROD_NAME, Arrays.asList(price1, price2), SCU);

            when(productRepository.findById(any())).thenReturn(Optional.of(product));
        }

        public void givenNoProduct()
        {
            when(productRepository.findById(any())).thenReturn(Optional.empty());
        }

        public ProductDTO whenGetProductIsCalled()
        {
            return service.getProduct(any());
        }

        public void thenProductIsReturned(ProductDTO result)
        {
            assertNotNull(result);
            assertEquals(PROD_NAME, result.getProd_name());
            assertEquals(SCU, result.getScu());
            assertEquals(2, result.getPrices().size());
            assertEquals(DATE_1, result.getPrices().get(0).getDate_from());
            assertEquals(DATE_2, result.getPrices().get(0).getDate_to());
            assertEquals(PRICE_1, result.getPrices().get(0).getPrice());
            assertEquals(DATE_3, result.getPrices().get(1).getDate_from());
            assertEquals(DATE_4, result.getPrices().get(1).getDate_to());
            assertEquals(PRICE_10, result.getPrices().get(1).getPrice());
        }

    }
}
