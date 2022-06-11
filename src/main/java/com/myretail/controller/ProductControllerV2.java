package com.myretail.controller;

import com.myretail.domain.Price;
import com.myretail.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping(value = "/v2/products")
public class ProductControllerV2 {

    //TODO add logging

    @Autowired
    ProductService productService;

    @Operation(summary = "Version 2: Saves the price only.  Product name is not saved in the repository")
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(
            @RequestBody Price newPrice,
            @PathVariable(value = "id") String id){

        //TODO error handling in case the new product can't be formed to the Product object
        productService.saveProduct(id,newPrice);
    }


}
