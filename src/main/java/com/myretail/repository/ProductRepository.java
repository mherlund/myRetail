package com.myretail.repository;

import com.myretail.domain.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ProductRepository extends MongoRepository<ProductPrice, String> {

//    ProductPrice findByKey(String id);

}
