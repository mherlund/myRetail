package com.myretail.service;


import com.myretail.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @Test
    public void getProduct1Test() throws Exception{
        ProductService productService = new ProductService();
        String returnedData = productService.lookupExternalData("13860428");
        Assertions.assertEquals("The Big Lebowski (Blu-ray)",returnedData);
    }

    @Test
    public void getProduct1Test_noData() throws Exception{
        ProductService productService = new ProductService();

        Assertions.assertThrows(ResourceNotFoundException.class, () -> productService.lookupExternalData("1"));
    }



}
