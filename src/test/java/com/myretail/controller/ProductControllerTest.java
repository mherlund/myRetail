package com.myretail.controller;

import com.myretail.domain.Price;
import com.myretail.domain.Product;
import com.myretail.repository.ProductRepository;
import com.myretail.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@WebAppConfiguration
public class ProductControllerTest {


    @MockBean
    private ProductService service;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getProduct1Test() throws Exception{
        Product testProduct = new Product("1","Mock Product 1",new Price(0.99,"USD"));

        // When getProduct is called for id 1, return the testProduct defined above
        given(service.getProduct("1")).willReturn(testProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/products/1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(testProduct.getName()))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                ;
    }
}
