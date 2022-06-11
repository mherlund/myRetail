package com.myretail;

import com.myretail.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyRetailApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MyRetailApplication.class, args);

		ProductService productService = applicationContext.getBean(ProductService.class);
		productService.loadSampleData();
	}

}
