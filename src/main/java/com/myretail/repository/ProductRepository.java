package com.myretail.repository;

import com.myretail.domain.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<ProductPrice, String> {

    ProductPrice findByName(String id);
}
