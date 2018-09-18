package com.myretail.controller;

import com.myretail.domain.Product;
import com.myretail.service.ProductService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping(value = "/v1/products")
public class ProductController {

    //TODO add logging

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable(value = "id") String id)
    {
        Product product = productService.getProduct(id);
//        if(product==null)
            // return NOT FOUND

        return product;
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(
            @ApiParam(name = "newProduct", value = "Message to send", required = true) @RequestBody Product newProduct,
            @PathVariable(value = "id") String id){


        //TODO: error handling in case the id on the URI doesn't match the ID in the JSON body

        //TODO error handling in case the new product can't be formed to the Product object
        productService.setProduct(newProduct);
    }
}
