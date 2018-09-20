package com.myretail.controller;

import com.myretail.Application;
import com.myretail.domain.Price;
import com.myretail.domain.Product;
import com.myretail.repository.ProductRepository;
import com.myretail.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ProductRepository repository;

    @Autowired
    ProductService productService;

    @Before
    public void setup(){
        repository.save(new Product("1","Product 1", new Price(2.99,"USD")));
        repository.save(new Product("2","Product 2", new Price(9.95,"USD")));
    }


    @Test
    public void getProduct1() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/v1/products/1")
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Product 1"))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
        ;
    }


    @Test
    public void getProductDoesNotExist() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/v1/products/3")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
        ;
    }


    @Test
    public void deleteProduct() throws Exception {

        repository.save(new Product("88","Product 1", new Price(2.99,"USD")));

        mvc.perform(MockMvcRequestBuilders.delete("/v1/products/88")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
        ;
    }



}
