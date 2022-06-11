package com.myretail.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@JsonPropertyOrder({ "id","name","currentPrice" })
public class Product {




    //@JsonProperty
//    @NotNull
    @Id
    private String id;

    @JsonProperty
    @NotNull
    private String name;

    @JsonProperty("current_price")
    @NotNull
    private Price currentPrice;


    public Product(String id, String name, Price currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    @JsonGetter("id")
    public int getId() {
        return Integer.parseInt(id);
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }

}
