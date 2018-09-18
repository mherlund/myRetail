package com.myretail.service;

import com.myretail.domain.Product;
import com.myretail.exceptions.ResourceNotFoundException;
import com.myretail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;



    public Product getProduct(String id){

        Optional<Product> product = repository.findById(id);

        //If the product is not found, throw ResourceNotFoundException which will return a 404
        if(!product.isPresent())
            throw new ResourceNotFoundException();

        return product.get();

    }


    public void setProduct(Product product){


        repository.save(product);


    }

}
