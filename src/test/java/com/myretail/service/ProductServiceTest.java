package com.myretail.service;


import org.junit.Assert;
import org.junit.Test;
import com.myretail.exceptions.ResourceNotFoundException;


public class ProductServiceTest {

    @Test
    public void getProduct1Test() throws Exception{
        ProductService productService = new ProductService();
        String returnedData = productService.lookupExternalData("13860428");
        Assert.assertEquals("The Big Lebowski (Blu-ray)",returnedData);
    }

    @Test
    public void getProduct1Test_noData() throws Exception{
        ProductService productService = new ProductService();

        Assert.assertThrows(ResourceNotFoundException.class, () -> productService.lookupExternalData("1"));
    }



}
