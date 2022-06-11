package com.myretail.service;


import org.junit.Test;


public class ProductServiceTest {

    @Test
    public void getProduct1Test() throws Exception{
        ProductService productService = new ProductService();
        productService.lookupExternalData("13860428");

    }


}
