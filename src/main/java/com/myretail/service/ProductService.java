package com.myretail.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.domain.Price;
import com.myretail.domain.Product;
import com.myretail.domain.ProductPrice;
import com.myretail.exceptions.IdDoesNotMatchException;
import com.myretail.exceptions.ResourceNotFoundException;
import com.myretail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    /**
     * Returns a Product object that contains product information.
     * If the product is not found in the repository, an exception
     * will be thrown.
     *
     * @param  id  a String number that is the id of the Product
     * @return      the Product for the given id
     * @throws ResourceNotFoundException if the id is not found
     */
    public Product getProduct(String id){

        String externalData;

        // Treating the external lookup as the source of truth, if the product isn't there,
        try {
            externalData = lookupExternalData(id);
        } catch (ResourceNotFoundException e) {
            // TODO: more error handling depending on how to treat missing prices
            throw e;
        }



        // Get product price from repository
        Optional<ProductPrice> productPrice = repository.findById(id);

        //If the product is not found, throw ResourceNotFoundException which will return a 404
        if(productPrice.isEmpty())
            throw new ResourceNotFoundException("Price is not found");

        Price price = new Price(productPrice.get());

        return new Product(id, externalData, price);

    }


    /**
     * Saves a Product object to the repository.  This will only save the price and not save a new product name.
     *
     * @param  id  the id object you want to save.  This id should match the id in the Product object
     * @param  product  the Product object you want to save
     * @throws IdDoesNotMatchException if the id does not match what is in the product
     */
    public void saveProduct(String id,Product product){

        // If the ID supplied doesn't match the ID product, throw an exception
        if(Integer.parseInt(id) != product.getId())
            throw new IdDoesNotMatchException("Product ID's don't match");
        else
            repository.save(new ProductPrice(id, product.getPrice()));
    }

    /**
     * Saves a ProductPrice object to the repository.
     * @param  id  the id object you want to save.
     * @param  price  the ProductPrice object you want to save
     */
    public void saveProduct(String id,Price price){

        repository.save(new ProductPrice(id, price));
    }

    /**
     * Deletes a Product with the given id from the repository.
     *
     * @param  id  the Product id you want to delete
     */
    public void removeProduct(String id){
        repository.deleteById(id);
    }


    public String lookupExternalData(String id) throws ResourceNotFoundException{

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response;

        String externalURL
                = "https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/"+
                "case_study_v1?key=3yUxt7WltYG7MFKPp7uyELi1K40ad2ys&tcin="+id;
        try{
            response = restTemplate.getForEntity(externalURL, String.class);
        }
        catch(HttpClientErrorException e){
            throw new ResourceNotFoundException("No data returned from" + externalURL, e);
        }
        catch(HttpServerErrorException e){
            throw e;
        }
        catch (Exception e){
            throw e;
        }

        // Spring is handling responses, so no extra checking for HTTP status codes
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String title = root.findPath("title").textValue();
        //TODO: error handling if title is not found

        return title;

    }




    public void loadSampleData(){
        repository.save(new ProductPrice("13860428", new Price(13.49,"USD")));
        repository.save(new ProductPrice("54456119", new Price(13.49,"USD")));
        repository.save(new ProductPrice("13264003", new Price(13.49,"USD")));
        repository.save(new ProductPrice("12954218", new Price(.89,"USD")));
    }

}
