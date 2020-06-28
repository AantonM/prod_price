package com.prodprice.prodprice_service.integrationTests.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodprice.prodprice_service.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerITTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductService productService;

    @Test
    void test_getProductPrice_successful() throws Exception
    {
        mockMvc.perform(get("/product/{productId}", 1)
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void test_getProduct_productDoesNotExist() throws Exception
    {
        mockMvc.perform(get("/product/{productId}", 0)
                .contentType("application/json"))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_getProduct_verifyPrice() throws Exception
    {
        String expectedPriceList = "{\"prod_name\":\"pastet\",\"prod_desc\":\"opisanie\"," +
                "\"prices\":[{\"date_from\":\"2020-05-29T23:00:00.000+0000\",\"date_to\":\"2020-06-29T23:00:00.000+0000\",\"price\":12.54}," +
                "{\"date_from\":\"2020-04-30T23:00:00.000+0000\",\"date_to\":\"2020-05-29T23:00:00.000+0000\",\"price\":25.99}," +
                "{\"date_from\":\"2020-03-31T23:00:00.000+0000\",\"date_to\":\"2020-04-29T23:00:00.000+0000\",\"price\":39.99}," +
                "{\"date_from\":\"2020-03-01T00:00:00.000+0000\",\"date_to\":\"2020-06-29T23:00:00.000+0000\",\"price\":5.99}," +
                "{\"date_from\":\"2020-02-01T00:00:00.000+0000\",\"date_to\":\"2020-06-29T23:00:00.000+0000\",\"price\":31.99}," +
                "{\"date_from\":\"2020-01-01T00:00:00.000+0000\",\"date_to\":\"2020-06-29T23:00:00.000+0000\",\"price\":12.99}]," +
                "\"scu\":12134}";

        MvcResult result = mockMvc.perform(get("/product/{productId}", 1)
                .contentType("application/json"))
                .andExpect(status().isOk()).andReturn();

        String actual = result.getResponse().getContentAsString();
        assertThat(actual).isEqualTo(expectedPriceList);
    }
}
