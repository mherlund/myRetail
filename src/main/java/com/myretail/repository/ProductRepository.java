package com.myretail.repository;

import com.myretail.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);
}
