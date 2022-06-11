package com.myretail.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class ProductPrice {
    //@JsonProperty
//    @NotNull
    @Id
    private String id;
    @JsonProperty
    @NotNull
    private Price currentPrice;

    public ProductPrice(String id, Price currentPrice) {
        this.id = id;
        this.currentPrice = currentPrice;
    }

    @JsonGetter("id")
    public int getId() {
        return Integer.parseInt(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public Price getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }
}
