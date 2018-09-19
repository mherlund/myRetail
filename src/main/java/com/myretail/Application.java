package com.myretail;

import com.myretail.domain.Price;
import com.myretail.domain.Product;
import com.myretail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // clear all data in the repository on startup
        repository.deleteAll();

        // save a couple of items
        repository.save(new Product("1","Product 1", new Price("$2.99","USD")));
        repository.save(new Product("2","Product 2", new Price("$9.95","USD")));



    }
}
