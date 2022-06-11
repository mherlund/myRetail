package com.myretail.controller;

import com.myretail.domain.Product;
import com.myretail.service.ProductService;
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
        //If the product id is not found an exception is thrown.
        return productService.getProduct(id);
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(
            @RequestBody Product newProduct,
            @PathVariable(value = "id") String id){

        //TODO error handling in case the new product can't be formed to the Product object
        productService.saveProduct(id,newProduct);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void removeProduct(@PathVariable(value = "id") String id)
    {
        productService.removeProduct(id);
    }
}
